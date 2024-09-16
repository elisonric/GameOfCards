package br.com.challenge.gameofcards.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "card")
public class Card {

      @Id
      @GeneratedValue(strategy = GenerationType.SEQUENCE)
      private Long id;

      @Column(name = "title")
      private String title;

      @Column(name = "value")
      private Integer value;

      public Card() {
      }

      public Card(Long id, String title, Integer value) {
            this.id = id;
            this.title = title;
            this.value = value;
      }

      public Long getId() {
            return id;
      }

      public String getTitle() {
            return title;
      }

      public Integer getValue() {
            return value;
      }
}
