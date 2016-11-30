package ie.turfclub.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.google.common.base.Objects;
 
@Entity
@Table(name="p2p_users")
public class User implements UserDetails {
    private static final long serialVersionUID = 6311364761937265306L;
    static Logger logger = LoggerFactory.getLogger(User.class);
     
    

	@Id
	 @GeneratedValue
	 @Column(name = "user_id")
	private Integer user_id;
    @NotNull(message = "{error.user.username.null}")
    @NotEmpty(message = "{error.user.username.empty}")
    @Size(max = 50, message = "{error.user.username.max}")
    @Column(name = "user_username", length = 50)
    private String user_username;
 
    @NotNull(message = "{error.user.password.null}")
    @NotEmpty(message = "{error.user.password.empty}")
    @Size(max = 50, message = "{error.user.password.max}")
    @Column(name = "user_password", length = 50)
    private String user_password;
     
    @Column(name = "user_enabled")
    private boolean user_enabled;
    
    @Column(name = "user_role")
    private String user_role;
    
	@NotFound(action=NotFoundAction.EXCEPTION)  
	@OneToOne( optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="user_hunt_id", nullable=true)
    private Hunt user_hunt_id;
    
    @Transient
    private Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
     
    
    
    
    public Integer getId() {
		return user_id;
	}

	public void setId(Integer id) {
		this.user_id = id;
	}

	@Override
	public String getUsername() {
        return user_username;
    }
 
    public void setUsername(String username) {
        this.user_username = username;
    }
 
    @Override
	public String getPassword() {
        return user_password;
    }
 
    public void setPassword(String password) {
        this.user_password = password;
    }
 
    public boolean getEnabled() {
        return user_enabled;
    }
 
    public void setEnabled(boolean enabled) {
        this.user_enabled = enabled;
    }
 
    public void setAuthorities(){
    	
    	Collection<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.user_role);
        authorities.add(authority);
        this.setAuthorities(authorities);
    	
    }
    
    
    
    public Hunt getUser_hunt_id() {
		return user_hunt_id;
	}

	public void setUser_hunt_id(Hunt user_hunt_id) {
		this.user_hunt_id = user_hunt_id;
	}

	@Override
    public String toString() {
        return String.format("%s(id=%d, username=%s, password=%s, enabled=%b)", 
                this.getClass().getSimpleName(), 
                this.getId(), 
                this.getUsername(), 
                this.getPassword(), 
                this.getEnabled());
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
 
        if (o instanceof User) {
            final User other = (User) o;
            return Objects.equal(getId(), other.getId())
                    && Objects.equal(getUsername(), other.getUsername())
                    && Objects.equal(getPassword(), other.getPassword())
                    && Objects.equal(getEnabled(), other.getEnabled());
        }
        return false;
    }
 
    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), getUsername(), getPassword(), getEnabled());
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }
     
    //TODO temporary authorities implementation - will revise in the next example
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
 
    @Override
    public boolean isAccountNonExpired() {
        //return true = account is valid / not expired
        return true; 
    }
 
    @Override
    public boolean isAccountNonLocked() {
        //return true = account is not locked
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        //return true = password is valid / not expired
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return this.getEnabled();
    }
     
}