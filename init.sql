CREATE TABLE "game" (
  "id" integer PRIMARY KEY,
  "id_deck" varchar,
  "players_number" integer,
  "id_winner" integer,
  "created_at" timestamp
);

CREATE TABLE "player" (
  "id" integer PRIMARY KEY,
  "id_game" integer,
  "name" varchar,
  "created_at" timestamp
);

CREATE TABLE "player_cards" (
  "id" integer PRIMARY KEY,
  "id_player" integer,
  "cards" varchar,
  "total_value" integer
);

ALTER TABLE "player" ADD FOREIGN KEY ("id_game") REFERENCES "game" ("id");

ALTER TABLE "player_cards" ADD FOREIGN KEY ("id_player") REFERENCES "player" ("id");

ALTER TABLE "game" ADD FOREIGN KEY ("id_winner") REFERENCES "player" ("id");