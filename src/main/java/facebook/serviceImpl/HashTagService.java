package facebook.serviceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Component;
import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Post;
import facebook.model.UserHashTag;
import facebook.service.HashTag;
/*
 * This service is to fetch all the Trending Hashtags that has been posted on UserHome 
 * which is captured RealTime to be displayed to user using Email Notification using Kafka messaging 
 */
@Component
public class HashTagService implements HashTag {
	
	
	 ArrayList<String> hashtag = new ArrayList<String>();
	 ArrayList<UserHashTag> hashtagList = new ArrayList<UserHashTag>();
	@Override
	public List<String> findTrendingHashTags(FacebookClient fbClient,
			String userId) {
		
		hashtag = new ArrayList<String>();
		Connection<Post> UserPost = fbClient.fetchConnection("me/home", Post.class, Parameter.with("fields","id,message,from"),Parameter.with("limit", 10));
		Pattern MY_PATTERN = Pattern.compile("#(\\w+)");			//RegEx Pattern to search  all the HashTags 
		
		Matcher mat ;
		System.out.println("HashTagService.findTrendingHashTags() I am inside Hashtags");
	try{
				
			for (Post posts: UserPost.getData()){
					if(posts.getMessage()!=null){
						//hashtag.clear();
					    	UserHashTag hash_tags   = new UserHashTag();
						    mat = MY_PATTERN.matcher(posts.getMessage());   //PatternMatching to segregate all the HashTags from the Posts        
							while (mat.find()) {
							 	System.out.println("HashTagService.findTrendingHashTags()------------------"+mat.group(1));
							 	//hashtag.add("testhashtag");
							 	hashtag.add(mat.group(1));
							}
							if(hashtag.size()>0 && !hashtag.isEmpty()){
										//hashtag.add("testhashtag");
							 	  		hash_tags.setHashTag(hashtag);
								 	  	hash_tags.setId(posts.getId().toString());
								 	  	hash_tags.setCreatedBy(posts.getFrom().toString());
								 	  	hashtagList.add(hash_tags);
							 	  	}
						 	  }
			            }
			    	
	   	 }
			catch(Exception e){
		e.printStackTrace();
	}
	return hashtag;
		
	}
	
}
