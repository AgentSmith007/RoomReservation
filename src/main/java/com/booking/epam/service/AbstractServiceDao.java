package com.booking.epam.service;

import com.booking.epam.entity.BaseEntity;
import com.booking.epam.exception.BookingException;
import com.booking.epam.repository.AbstractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.transaction.annotation.Propagation.REQUIRED;

public class AbstractServiceDao<E extends BaseEntity, R extends AbstractRepository<E>> {
    protected final R repository;

    @Autowired
    public AbstractServiceDao(R repository) {
        this.repository = repository;
    }

    @Transactional(propagation = REQUIRED, readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

//    @Transactional(propagation = REQUIRED, readOnly = true)
//    public List<E> findAll(@Nullable Specification<E> spec) {
//        return repository.findAll(spec);
//    }

    @Transactional(propagation = REQUIRED, readOnly = true)
    public E findById(UUID id) {
        Optional<E> op = repository.findById(id);

        if (!op.isPresent()) {
            throw new BookingException("Значение не найдено", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return op.get();
    }

    @Transactional(propagation = REQUIRED)
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Transactional(propagation = REQUIRED)
    public void delete(E entity) {
        repository.delete(entity);
    }

    @Transactional(propagation = REQUIRED)
    public E save(E entity) {
        return repository.save(entity);
    }
}
