package com.example.blog

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository,
    val articleRepository: ArticleRepository) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        val article = Article("Spring Framework 5.0 goes GA", "Dear Spring community ...", "Lorem ipsum", juergen)
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!) ?: Article("", "", "", User("", "", ""), "")
        assert(found.equals(article))
    }

    @Test
    fun `When findByLogin then return User`() {
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        entityManager.flush()
        val user = userRepository.findByLogin(juergen.login) ?: User("", "", "")
        assert(user.equals(juergen))
    }
}