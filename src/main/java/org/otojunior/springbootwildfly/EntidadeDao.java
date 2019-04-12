/**
 * 
 */
package org.otojunior.springbootwildfly;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 01456231650
 *
 */
public interface EntidadeDao extends JpaRepository<Entidade, Long> {
	public List<Entidade> findByCodigoOrderByCodigo(Long codigo);
}