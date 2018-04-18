package com.nouhoun.springboot.jwt.integration;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nouhoun.springboot.jwt.integration.domain.Empresa;
import com.nouhoun.springboot.jwt.integration.domain.Endereco;
import com.nouhoun.springboot.jwt.integration.domain.Quadra;
import com.nouhoun.springboot.jwt.integration.domain.Quadra.Cobertura;
import com.nouhoun.springboot.jwt.integration.domain.Quadra.Tipo;
import com.nouhoun.springboot.jwt.integration.domain.Role;
import com.nouhoun.springboot.jwt.integration.domain.User;
import com.nouhoun.springboot.jwt.integration.service.EmpresaService;



@RunWith(SpringJUnit4ClassRunner.class)
public class EmpresaServiceTest {


    @Mock
	private EmpresaService empresaService;
	
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(empresaService.findEmpresaByEmail("wlclimaco@gmail.com")).thenReturn(listEmpresa("wlclimaco@gmail.com",10));

    }

    @After
    public void tearDown() {
    }

    @Test
    public void findAllUser() {
        Empresa batchData = empresaService.findEmpresaByEmail("wlclimaco@gmail.com");
        assertEquals("wlclimaco@gmail.com", batchData.getEmail());

    }
    
    @Before
    public void setUp2() {
        List<Empresa> dataList = new ArrayList<Empresa>();

        dataList.add(listEmpresa("wlclimaco@gmail.com",10));
        dataList.add(listEmpresa("wlclimaco@hotmail.com",100));
     
        Mockito.when(empresaService.findEmpresaByUser("wlclimaco@hotmail.com"))
          .thenReturn(dataList);
    }

    @Test
    public void findUserByEmail() {
    	
    	
    	List<Empresa> batchData = empresaService.findEmpresaByUser("wlclimaco@hotmail.com");
        assertEquals(2, batchData.size());

    }
    
    @Before
    public void setUp3() {
        List<Empresa> dataList = new ArrayList<Empresa>();

        dataList.add(listEmpresa("wlclimaco@gmail.com",10));
        dataList.add(listEmpresa("wlclimaco@hotmail.com",100));
     
        Mockito.when(empresaService.findAllEmpresa())
          .thenReturn(dataList);
    }

    @Test
    public void findAllEmpresa() {
    	
    	
    	List<Empresa> batchData = empresaService.findAllEmpresa();
        assertEquals(2, batchData.size());

    }
    
    public Empresa listEmpresa(String email,Integer id){
    	
    	Empresa empresa = new Empresa();
    	empresa.setId(id);
    	empresa.setNome("nome");
    	empresa.setNomeResponsavel("nomeResponsavel");
    	empresa.setEmail(email);;
    	empresa.setTelefone("telefone");
    	Endereco endereco = new Endereco();
    	endereco.setId(id + 1000);
    	endereco.setBairro("bairro");
    	endereco.setCidade("cidade");
    	endereco.setEstadoId(1);
    	endereco.setLat("5441454141");
    	endereco.setLongi("5417854");  	
    	empresa.setEndereco(endereco);
    	empresa.setEnderecoId(1);
    	Quadra quadra = new Quadra();
    	quadra.setCobertura(Cobertura.NAO  );
    	quadra.setComBola(1);
    	quadra.setDescricao("descricao");
    	quadra.setEmpresaId(id);
    	quadra.setNome("nome");
    	quadra.setTempoJogo("90");
    	quadra.setTipo(Tipo.GRAMA);
    	quadra.setValor((float) 1.2);
    	
    	empresa.setQuadras(Arrays.asList(quadra));
    	
    	return empresa;
    }

}
