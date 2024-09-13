package br.com.challenge.gameofcards.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "card")
public class Card {

      @Id
      private Integer id;

      @Column(name = "title")
      private String title;

      @Column(name = "value")
      private Integer value;

      public Card() {
      }

      public Card(Integer id, String title, Integer value) {
            this.id = id;
            this.title = title;
            this.value = value;
      }

      public Integer getId() {
            return id;
      }

      public String getTitle() {
            return title;
      }

      public Integer getValue() {
            return value;
      }
}
