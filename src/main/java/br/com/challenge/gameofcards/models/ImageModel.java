package br.com.challenge.gameofcards.models;

public class ImageModel {

    private String svg;

    private String png;

    public ImageModel() {
    }

    public ImageModel(String svg, String png) {
        this.svg = svg;
        this.png = png;
    }

    public String getSvg() {
        return svg;
    }

    public String getPng() {
        return png;
    }
}
