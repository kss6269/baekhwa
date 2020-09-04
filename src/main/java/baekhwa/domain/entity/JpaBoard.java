package baekhwa.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@EntityListeners(AuditingEntityListener.class)//날짜 다동으로 입력처리하기위해..
//@SequenceGenerator(name="seq_ao", sequenceName = "SEQ_JBOARD", initialValue = 1, allocationSize = 1)
@Table(name = "jpa_board")
@Entity
public class JpaBoard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	
	private Long no;
	
	@Column(nullable = false)//not null	
	private String subject;
	@Column(nullable = false)
	private String writer;
	@Column(nullable = false)
	private String user_ip;
	
	@Column(columnDefinition = "text", nullable = false)
	private String content;
	
	private int count;
	
	@CreatedDate//데이터가 처음 만들어질때 자동생성
	@Column(nullable = false)
	private LocalDateTime reg_date;
	
	//@LastModifiedDate //데이터가 수정이 되면 자동으로 수정일 자동생성
	private LocalDateTime edit_date;

	public JpaBoard(String subject, String writer, String user_ip, String content) {
		super();
		this.subject = subject;
		this.writer = writer;
		this.user_ip = user_ip;
		this.content = content;
	}
	
	
	

}
