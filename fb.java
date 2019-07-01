import facebook4j.Comment;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.PagableList;
import facebook4j.Post;
import facebook4j.Reading;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

 class PostsFromPageExtractor {

/**
 * A simple Facebook4J client which
 * illustrates how to access group feeds / posts / comments.
 * 
 * @param args
 * @throws FacebookException 
 */
public static void main(String[] args) throws FacebookException {

    // Generate facebook instance.
    Facebook facebook = new FacebookFactory().getInstance();
    // Use default values for oauth app id.
    facebook.setOAuthAppId("945286499156695", "9QBmdNrWUviApMUtkTzLKYyz6LY");
    // Get an access token from: 
    // https://developers.facebook.com/tools/explorer
    // Copy and paste it below.
    String accessTokenString = "EAANbu6nZBQtcBAD84rkaTQkmYMUjakx3haVFdiNGLPYyrHyg1wIVJxeMdcDUVmMX59BMrcUDZCDN0oGgR6ajgCMLkaugGIyv8lxefekdP32xmfAOSU7NnAU4ibZAoYJZAExZB0qRo356XYp9gKuayEoysfWLSdmvuwassPAmctjlK0NDRr8IgABxFrEapjdIZD";
    AccessToken at = new AccessToken(accessTokenString);
    // Set access token.
    facebook.setOAuthAccessToken(at);

    // We're done.
    // Access group feeds.
    // You can get the group ID from:
    // https://developers.facebook.com/tools/explorer

    // Set limit to 25 feeds.
    ResponseList<Post> feeds = facebook.getFeed("118599706070960",
            new Reading().limit(25));

        // For all 25 feeds...
        for (int i = 0; i < feeds.size(); i++) {
            // Get post.
            Post post = feeds.get(i);
            // Get (string) message.
            String message = post.getMessage();
                            // Print out the message.
            System.out.println(message);

            // Get more stuff...
            PagableList<Comment> comments = post.getComments();
            String date = post.getCreatedTime().toString();
            String name = post.getFrom().getName();
            String id = post.getId();
        }           
    }
}