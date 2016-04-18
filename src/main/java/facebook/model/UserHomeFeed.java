package facebook.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.springframework.data.annotation.Id;

public class UserHomeFeed {

	
	@Id
	@NotNull
	private String id;
	
	@NotNull
	private String userid;
	
	@Null
	private String saved_date;
	
	@Null
	private String created_date;
	
	@Null
	private String link;
	
	@Null
	private String type;
	
	@Null
	private Boolean like;
	
	@Null
	private String message;
	
	@Null
	private String picture;
	
	@Null
	private String source;
	
	
	private Set<UserComment> comments = new HashSet<UserComment>();
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getLike() {
		return like;
	}
	public void setLike(Boolean like) {
		this.like = like;
	}
	public Set<UserComment> getComments() {
		return comments;
	}
	public void setComments(Set<UserComment> comments) {
		this.comments = comments;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSaved_date() {
		return saved_date;
	}
	public void setSaved_date(String saved_date) {
		this.saved_date = saved_date;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Override
	public String toString() {
		return "UserHomeFeed [id=" + id + ", userid=" + userid
				+ ", saved_date=" + saved_date + ", created_date="
				+ created_date + ", link=" + link + ", type=" + type
				+ ", like=" + like + ", message=" + message + ", picture="
				+ picture + "source=" + source + ", comments=" + comments + "]";
	}

}
