package publiccode.designpattern.builder;

public class Post {
    private final String title;
    private final String content;
    private final String author;

    private Post(PostBuilder postBuilder) {
        title = postBuilder.title;
        content = postBuilder.content;
        author = postBuilder.author;
    }

    public static PostBuilder builder() {
        return new PostBuilder();
    }

    public static class PostBuilder {
        private String title;
        private String content;
        private String author;

        private PostBuilder() {
        }

        public PostBuilder title(String title) {
            this.title = title;
            return this;
        }

        public PostBuilder content(String content) {
            this.content = content;
            return this;
        }

        public PostBuilder author(String author) {
            this.author = author;
            return this;
        }

        public Post build() {
            return new Post(this);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Post post = Post.builder()
                .title("제목")
                .content("내용")
                .author("작성자")
                .build();
    }
}
