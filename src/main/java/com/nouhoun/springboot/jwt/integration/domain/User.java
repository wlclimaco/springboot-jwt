package com.nouhoun.springboot.jwt.integration.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "user")
public class User{
	
	 public enum Status {
	        INATIVO,ATIVO, SUSPENSO, AGUARDANDO
	    }
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Integer id;
	
	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	@Column(name = "password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
	@NotEmpty(message = "*Please provide your password")
	@Transient
	private String password;
	@Column(name = "nome")
	@NotEmpty(message = "*Favor Infomar o nome")
	private String nome;

	@Column(name = "active")
	private Status active;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns
            = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

	@Column(name = "iv")
	private String iv;
	@Column(name = "salt")
	private String salt;
	
	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name= "user_id", insertable = false,unique = false, nullable = false, updatable = false)
//	@OneToMany
	//@JoinTable(name = "jogo_por_data", joinColumns = @JoinColumn(name = "user_id",insertable = false,unique = false, nullable = false, updatable = false))
	//private List<Jogo> jogos;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id",  insertable = false,unique = false, nullable = false, updatable = false)
	private List<Notificacoes> notificacoes;
	
	private int keySize;
	private int iterations;
    @Column(name = "loginCount")
    private @JsonIgnore Integer loginCount;
    @Column(name = "currentLoginAt")
    private Date currentLoginAt;
    @Column(name = "lastLoginAt")
    private Date lastLoginAt;
    @Column(name = "currentLoginIp")
    private @JsonIgnore String currentLoginIp;
    @Column(name = "lastLoginIp")
    private @JsonIgnore String lastLoginIp;
    @Column(name = "updatedAt")
    private @JsonIgnore Date updatedAt;
    
    @Column(name = "enabled", columnDefinition="Boolean default true")
    private Boolean enabled;
    
    @Column(name = "isGoleiro", columnDefinition="Boolean default false")
    private Boolean isGoleiro;
    
    @Column(name = "foto")
    private String foto;
    
    @Column(name = "receberNotificacoes", columnDefinition="Boolean default true")
    private Boolean receberNotificacoes;
    
   // @OneToOne(fetch = FetchType.EAGER)
  //  @JoinTable(name = "empresa", joinColumns = @JoinColumn(name = "empresa_id",  unique = false, insertable = false, updatable = false))
  //  @OneToOne(optional = true)
   // @JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id", insertable = false, updatable = false)
   // private Empresa empresa;

    @Column(name = "empresa_id")
    private Integer empresaId;
    
    
    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Status getActive() {
		return active;
	}

	public void setActive(Status active) {
		this.active = active;
	}



	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getKeySize() {
		return keySize;
	}

	public void setKeySize(int keySize) {
		this.keySize = keySize;
	}

	public int getIterations() {
		return iterations;
	}

	public void setIterations(int iterations) {
		this.iterations = iterations;
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
     * Method to create the hash of the password before storing
     *
     * @param pass
     *
     * @return SHA hash digest of the password
     */
    public static synchronized String hashPassword(String pass) {
        return passwordEncoder.encode(pass);
    }

    public static synchronized boolean doesPasswordMatch(String rawPass, String encodedPass) {
        return passwordEncoder.matches(rawPass, encodedPass);
    }

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Date getCurrentLoginAt() {
		return currentLoginAt;
	}

	public void setCurrentLoginAt(Date currentLoginAt) {
		this.currentLoginAt = currentLoginAt;
	}

	public Date getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(Date lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public String getCurrentLoginIp() {
		return currentLoginIp;
	}

	public void setCurrentLoginIp(String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public static BCryptPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public static void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		User.passwordEncoder = passwordEncoder;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public Integer getId() {
		return id;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnabled() {
        return this.enabled;
    }

	public User(String email, String password, String name, String lastName, Status active, String roleName,
			boolean enabled) {
		super();
		Role role = new Role(roleName);
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		this.email = email;
		this.password = password;
		this.nome = name;
		this.active = active;
		this.roles = roles;
		this.enabled = enabled;
	}
	
	public User(UserDTO user) {
		super();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.nome = user.getNome();
		this.active = user.getActive();
		this.roles = user.getRoles();
		this.enabled = user.getEnabled();
		this.isGoleiro = user.getIsGoleiro();
	}

	public User() {
		super();
	}


	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Notificacoes> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(List<Notificacoes> notificacoes) {
		this.notificacoes = notificacoes;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getReceberNotificacoes() {
		return receberNotificacoes;
	}

	public void setReceberNotificacoes(Boolean receberNotificacoes) {
		this.receberNotificacoes = receberNotificacoes;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Boolean getIsGoleiro() {
		return isGoleiro;
	}

	public void setIsGoleiro(Boolean isGoleiro) {
		this.isGoleiro = isGoleiro;
	}

	public User(Integer id, String username, String email, String password, String name, Status active,
			Integer empresaId) {
		super();
		this.id = id;
		this.nome = username;
		this.email = email;
		this.password = password;
		this.active = active;
		this.empresaId = empresaId;
	}
	
	
	
	
}
