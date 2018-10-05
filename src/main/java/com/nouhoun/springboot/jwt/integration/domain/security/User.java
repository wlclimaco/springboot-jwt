package com.nouhoun.springboot.jwt.integration.domain.security;

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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nouhoun.springboot.jwt.integration.domain.Estado;
import com.nouhoun.springboot.jwt.integration.domain.Notificacoes;

import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "USERNAME", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    @Column(name = "NOME", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String name;

    @Column(name = "EMAIL", length = 50)
    @NotNull
    @Size(min = 4, max = 50)
    private String email;

    @Column(name = "ENABLED")
    @NotNull
    private Boolean enabled;

    @Column(name = "LASTPASSWORDRESETDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private List<Authority> authorities;
    
    
	public enum Status {
		INATIVO, ATIVO, SUSPENSO, AGUARDANDO
	}

	
	@Column(name = "active")
	private Status active;
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	private List<Role> roles;

	@Column(name = "iv")
	private String iv;
	@Column(name = "salt")
	private String salt;

	@Column(name = "cep")
	private String cep;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numero")
	private String numero;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "referencia")
	private String referencia;

	@Column(name = "cidade")
	private String cidade;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "estado_id", insertable = false, unique = false, nullable = false, updatable = false)
	private Estado estado;

	@Column(name = "estado_id")
	private Integer estadoId;

	@Column(name = "longi")
	private String longi;

	@Column(name = "lat")
	private String lat;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id", insertable = false, unique = false, nullable = false, updatable = false)
//	private List<Notificacoes> notificacoes;

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

	@Column(name = "isGoleiro", columnDefinition = "Boolean default false")
	private Boolean isGoleiro;

	@Column(name = "isEnviarNotifPorEmail", columnDefinition = "Boolean default true")
	private Boolean isEnviarNotifPorEmail;

	@Column(name = "foto")
	private String foto;

	@Column(name = "receberNotificacoes", columnDefinition = "Boolean default true")
	private Boolean receberNotificacoes;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, unique = false, nullable = false, updatable = false)
	private List<Notificacoes> notificacoes;


	@Column(name = "telefone1")
	private String telefone1;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "empresa_id")
	private Integer empresaId;
	
	private Integer qntJogos;
	private Integer qntGols;
	private Double  mediaNota;
	private Double  mediaGols;

	private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	
	public static synchronized String hashPassword(String pass) {
		return passwordEncoder.encode(pass);
	}
	
	public static synchronized boolean doesPasswordMatch(String rawPass, String encodedPass) {
		return passwordEncoder.matches(rawPass, encodedPass);
	}
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

	public Status getActive() {
		return active;
	}

	public void setActive(Status active) {
		this.active = active;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Integer getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(Integer estadoId) {
		this.estadoId = estadoId;
	}

	public String getLongi() {
		return longi;
	}

	public void setLongi(String longi) {
		this.longi = longi;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
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

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getIsGoleiro() {
		return isGoleiro;
	}

	public void setIsGoleiro(Boolean isGoleiro) {
		this.isGoleiro = isGoleiro;
	}

	public Boolean getIsEnviarNotifPorEmail() {
		return isEnviarNotifPorEmail;
	}

	public void setIsEnviarNotifPorEmail(Boolean isEnviarNotifPorEmail) {
		this.isEnviarNotifPorEmail = isEnviarNotifPorEmail;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Boolean getReceberNotificacoes() {
		return receberNotificacoes;
	}

	public void setReceberNotificacoes(Boolean receberNotificacoes) {
		this.receberNotificacoes = receberNotificacoes;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Integer empresaId) {
		this.empresaId = empresaId;
	}

	public Integer getQntJogos() {
		return qntJogos;
	}

	public void setQntJogos(Integer qntJogos) {
		this.qntJogos = qntJogos;
	}

	public Integer getQntGols() {
		return qntGols;
	}

	public void setQntGols(Integer qntGols) {
		this.qntGols = qntGols;
	}

	public Double getMediaNota() {
		return mediaNota;
	}

	public void setMediaNota(Double mediaNota) {
		this.mediaNota = mediaNota;
	}

	public Double getMediaGols() {
		return mediaGols;
	}

	public void setMediaGols(Double mediaGols) {
		this.mediaGols = mediaGols;
	}

	public static BCryptPasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public static void setPasswordEncoder(BCryptPasswordEncoder passwordEncoder) {
		User.passwordEncoder = passwordEncoder;
	}

	public List<Notificacoes> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(List<Notificacoes> notificacoes) {
		this.notificacoes = notificacoes;
	}
    
    
}