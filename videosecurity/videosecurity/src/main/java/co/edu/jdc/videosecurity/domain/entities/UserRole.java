package co.edu.jdc.videosecurity.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "security_user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "usr_user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_role_user"))
    private User user;
    @ManyToOne(optional = false)
    @JoinColumn(name = "usr_role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_role_role"))
    private Role role;
}
