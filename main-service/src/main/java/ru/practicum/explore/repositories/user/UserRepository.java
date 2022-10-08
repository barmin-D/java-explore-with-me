package ru.practicum.explore.repositories.user;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.explore.models.user.User;

import java.util.List;

/**
 * Интерфейс репозитория пользователей
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /*
    Метод получения пользователей по ids
    */
    @Query("select u from User u where u.id IN ?1 order by u.id")
    List<User> findAllByIdOrderByIdDesc(List<Long> ids, Pageable pageable);
}
