# Backend cheat sheet

Every backend feature (`event/`, `seat/`, ...) is built from the same pieces. Follow one request through the system and each file is one stop along the way:

**Browser → Controller → Service → Repository → Database**, and the answer travels back out as a **Response**.

## The pieces

| Piece | Its one job | What goes in the file | Example |
|---|---|---|---|
| **Migration** (`.sql`) | Creates the table | `CREATE TABLE` or `INSERT` statements | `V3__create_venues_and_seats.sql` |
| **Entity** | Describes one row of the table as a Java object | `@Entity`, one field per column, getters | `Seat.java` |
| **Repository** | Fetches and saves rows | An interface with method names; Spring writes the SQL | `SeatRepository.java` |
| **Service** | Applies the rules and decides what to return | Methods that call the repository and convert entities to responses | `SeatService.java` |
| **Response** (DTO) | Defines the JSON the frontend sees | Only the fields you want to expose | `SeatResponse.java` |
| **Controller** | Maps a URL to a service method | `@GetMapping` paths; no logic | `SeatController.java` |

Optional: a custom **exception** such as `EventNotFoundException.java`, which turns "that id doesn't exist" into a 404.

## Where does this code belong?

- **Controller:** "What URL is this?"
- **Service:** "What are the rules?"
- **Repository:** "What do I need from the database?"
- **Entity:** "What does a row look like?"
- **Response:** "What should the frontend see?"

## Order to write them in

Work from the database outward, so each file only depends on ones already written:

1. Migration
2. Entity
3. Repository
4. Response
5. Service
6. Controller

Then restart the backend. New Java code and new migrations are only picked up on restart.

## Things that have tripped me up

- **Column names:** the name in `@Column(name = "...")` must match the database column exactly. The Java field name can be different (`rowLabel` for the `row` column). A mismatch stops the backend from starting.
- **Repository method names:** Spring builds the query from the entity's *field* names, not the column names: `findByVenueIdOrderByRowLabelAscSeatNumberAsc`.
- **URL paths:** Spring joins the class-level `@RequestMapping` and the method-level `@GetMapping`, in that order. `"/api/venues"` + `"/{venueId}/seats"` gives `/api/venues/1/seats`.
- **The `/api` prefix:** the frontend only forwards requests that start with `/api`, so every endpoint needs it.
- **Migrations are permanent:** never edit a migration that has already run. Add a new `V5__...sql` instead. To start over locally: `docker compose down -v`, then `docker compose up -d`.
