package ru.uppskilling;

public class Main {

    public static void main(String[] args) {
        Tree<String> root = new Tree<String>("Root");

        Node<String> video = root.addChild("Video");
        Node<String> picture = root.addChild("Picture");
        Node<String> music = root.addChild("Music");

        video.addChild("Matrix");
        video.addChild("Equilibrium");

        music.addChild("30 Second To Mars");
        music.addChild("Limp Bizkit");

        Node<String> picture1 = picture.addChild("Vincent Van Gogh");
        picture1.addChild("Sunflowers");
        picture1.addChild("Worn out");

        Tree.printTree(root);
        System.out.println(Tree.contains(root.getChildren(), "Matrix"));
    }

}
