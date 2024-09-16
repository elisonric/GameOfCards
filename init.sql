CREATE TABLE "game" (
  "id" BIGSERIAL PRIMARY KEY,
  "id_deck" varchar,
  "players_number" integer,
  "created_at" timestamp
);

CREATE TABLE "player" (
  "id" BIGSERIAL PRIMARY KEY,
  "id_game" BIGSERIAL ,
  "name" varchar,
  "created_at" timestamp
);

CREATE TABLE "player_cards" (
  "id" BIGSERIAL PRIMARY KEY,
  "id_player" BIGSERIAL,
  "cards" varchar,
  "total_value" integer
);

CREATE TABLE "game_winner" (
    "id_game" BIGSERIAL ,
    "id_player" BIGSERIAL ,
    PRIMARY KEY (id_game, id_player)
);

ALTER TABLE "player" ADD FOREIGN KEY ("id_game") REFERENCES "game" ("id");

ALTER TABLE "player_cards" ADD FOREIGN KEY ("id_player") REFERENCES "player" ("id");

ALTER TABLE "game_winner" ADD FOREIGN KEY ("id_game") REFERENCES "game" ("id");

ALTER TABLE "game_winner" ADD FOREIGN KEY ("id_player") REFERENCES "player" ("id");