package project.controller;


import project.time.ConsoleColors;

public class Main {
    public static void main(String[] args) {
        StoryRunner storyRunner = new StoryRunner();
        storyRunner.run(4);
        System.out.println(ConsoleColors.RESET);
    }
}
