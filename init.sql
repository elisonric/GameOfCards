CREATE TABLE "game" (
  "id" integer PRIMARY KEY,
  "name" varchar,
  "players_number" integer,
  "created_at" timestamp
);

CREATE TABLE "player" (
  "id" integer PRIMARY KEY,
  "id_game" integer,
  "name" varchar,
  "created_at" timestamp
);

CREATE TABLE "card" (
  "id" integer PRIMARY KEY,
  "title" varchar,
  "value" integer
);

CREATE TABLE "player_cards" (
  "id" integer PRIMARY KEY,
  "id_player" integer,
  "cards" varchar,
  "total_value" integer
);

ALTER TABLE "player" ADD FOREIGN KEY ("id_game") REFERENCES "game" ("id");

ALTER TABLE "player_cards" ADD FOREIGN KEY ("id_player") REFERENCES "player" ("id");