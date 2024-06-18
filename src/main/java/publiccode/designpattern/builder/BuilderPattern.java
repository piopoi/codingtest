package publiccode.designpattern.builder;

public class BuilderPattern {
    private final String title;
    private final String content;
    private final String author;

    private BuilderPattern(BuilderPatternBuilder builderPatternBuilder) {
        title = builderPatternBuilder.title;
        content = builderPatternBuilder.content;
        author = builderPatternBuilder.author;
    }

    public static BuilderPatternBuilder builder() {
        return new BuilderPatternBuilder();
    }

    public static class BuilderPatternBuilder {
        private String title;
        private String content;
        private String author;

        private BuilderPatternBuilder() {
        }

        public BuilderPatternBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BuilderPatternBuilder content(String content) {
            this.content = content;
            return this;
        }

        public BuilderPatternBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BuilderPattern build() {
            return new BuilderPattern(this);
        }
    }
}

class Main {
    public static void main(String[] args) {
        BuilderPattern builderPattern = BuilderPattern.builder()
                .title("제목")
                .content("내용")
                .author("작성자")
                .build();
    }
}
