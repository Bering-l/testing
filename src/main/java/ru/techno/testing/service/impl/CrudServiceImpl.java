package ru.techno.testing.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.techno.testing.exception.EntityNotFoundException;
import ru.techno.testing.model.BaseEntity;
import ru.techno.testing.repository.BaseRepository;
import ru.techno.testing.service.CrudService;

import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
public abstract class CrudServiceImpl<E extends BaseEntity, R extends BaseRepository<E>>
        implements CrudService<E> {

    final R repository;
    final Class<E> genericType;

    protected CrudServiceImpl(R repository, Class<E> genericType) {
        this.repository = repository;
        this.genericType = genericType;
    }

    @Override
    public E getById(Integer id) {
        Optional<E> entity = this.repository.findById(id);
        if (entity.isPresent()) {
            log.info(this.genericType.getSimpleName() + " get, id: " + id);
            return entity.get();
        }
        log.error(this.genericType.getSimpleName() + " don't get, id: " + id);
        throw new EntityNotFoundException(id, this.genericType.getSimpleName());
    }

    @Override
    @Transactional
    public void save(E e) {
        try {
            E save = this.repository.save(e);
            log.info(this.genericType.getSimpleName() + " save, id: " + e.getId());
        } catch (Exception ex) {
            log.error(this.genericType.getSimpleName() + " wasn't save, id: " +
                    e.getId());
            throw new RuntimeException(this.genericType.getSimpleName());
        }
    }


    @Override
    public void delete(Integer id) {
        try {
            this.repository.deleteById(id);
            log.info(this.genericType.getSimpleName() + " delete, id: " + id);
        } catch (Exception ex) {
            log.error(this.genericType.getSimpleName() + " don't delete, id: " + id
                    + " Error message: " + ex.getMessage());
        }
    }

    @Override
    @Transactional
    public E update(Integer id, E e) {
        try {
            this.repository.findById(id).ifPresent(a -> save(e));
            log.info(e + " update");
            return e;
        } catch (Exception ex) {
            log.error(e + " don't update");
            throw new RuntimeException(this.genericType.getSimpleName());
        }
    }

    @Override
    public Page<E> findAll(Integer pageNumber, String sortField, String sortDirection) {
        Pageable pageable = findAllWithPagination(pageNumber, sortField, sortDirection);
        Page<E> all = repository.findAll(pageable);
        log.info("Page " + this.genericType.getSimpleName() + " create");
        return all;
    }

    public Pageable findAllWithPagination(final Integer pageNumber,
                                          final String sortField, final String sortDirection) {
        final int pageSize = 3;
        PageRequest pageRequest = PageRequest.of(pageNumber - 1, pageSize);
        if (sortField != null && sortField.equalsIgnoreCase("sort")) {
            pageRequest = PageRequest.of(pageNumber - 1, pageSize);
            log.info(this.genericType.getSimpleName() + " sort by: " + sortField);
        } else if (sortField != null && sortDirection != null) {
            Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                    Sort.by(sortField).ascending() : Sort.by(sortField).descending();
            pageRequest = PageRequest.of(pageNumber - 1, pageSize, sort);
            log.info(this.genericType.getSimpleName() + " sort by: " + sortField);
        }
        return pageRequest;
    }
}
