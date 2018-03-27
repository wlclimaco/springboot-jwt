package com.nouhoun.springboot.jwt.integration.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author: kameshr
 */
public class UserDTO {

	private int id;
	private String email;
	private String username;
	private String password;
	private String name;
	private String lastName;
	private int active;
	private int isDono;
	private Set<Role> roles;
	private String iv;
	private String salt;
	private int keySize;
	private int iterations;
    private Integer loginCount;
    private Date currentLoginAt;
    private Date lastLoginAt;
    private String currentLoginIp;
    private String lastLoginIp;
    private String foto;
    private Date updatedAt;
    private Boolean enabled;
    private String encryptedPassword;
    private List<Jogo> jogos;
    private List<Notificacoes> notificacoes;
    private Boolean receberNotificacoes;
    private Boolean isGoleiro;

    public List<Notificacoes> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(List<Notificacoes> notificacoes) {
		this.notificacoes = notificacoes;
	}

	public Boolean getReceberNotificacoes() {
		return receberNotificacoes;
	}

	public void setReceberNotificacoes(Boolean receberNotificacoes) {
		this.receberNotificacoes = receberNotificacoes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public int getIsDono() {
		return isDono;
	}

	public void setIsDono(int isDono) {
		this.isDono = isDono;
	}

	public UserDTO() {
		super();
	}

	public UserDTO(String email, String password, String encryptedPassword) {
		super();
		this.email = email;
		this.password = password;
	}

	public UserDTO(String email, String password, String iv, String salt, int keySize,
			int iterations,String encryptedPassword) {
		super();
		this.email = email;
		this.password = password;
		this.iv = iv;
		this.salt = salt;
		this.keySize = keySize;
		this.iterations = iterations;
		this.encryptedPassword = encryptedPassword;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
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

    
}
