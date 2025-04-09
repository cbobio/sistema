package com.projeto.sistema.repositorio;

import com.projeto.sistema.models.Usuarios;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepo extends CrudRepository<Usuarios, Integer> {
    @Query(value="select CASE WHEN count(1) > 0 THEN 'true' ELSE 'false' END  from usuarios where id = :id", nativeQuery = true)
    public boolean exist(int id);

    @Query(value="select * from usuarios where email = :email and senha = :senha", nativeQuery = true)
    public Usuarios Login(String email, String senha);
}
