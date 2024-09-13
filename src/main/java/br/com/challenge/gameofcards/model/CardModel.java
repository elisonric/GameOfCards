package br.com.challenge.gameofcards.model;

public class CardModel {

    private String code;

    private String image;

    private ImageModel images;

    private String value;

    private String siut;

    public CardModel() {
    }

    public CardModel(String code, String image, ImageModel images, String value, String siut) {
        this.code = code;
        this.image = image;
        this.images = images;
        this.value = value;
        this.siut = siut;
    }

    public String getCode() {
        return code;
    }

    public String getImage() {
        return image;
    }

    public ImageModel getImages() {
        return images;
    }

    public String getValue() {
        return value;
    }

    public String getSiut() {
        return siut;
    }
}
