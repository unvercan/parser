# Parser – Factory & Iterator Pattern Demo

A modular, extensible Java-based parser system implemented using the **Factory** and **Iterator** design patterns.  
It demonstrates clean separation of parsing logic and flexible traversal over rows and columns from a delimited content source.

---

## Features

- `ColumnFactory` class for dynamic column creation based on type
    - Supports `TextColumn`, `NumericColumn`, `BooleanColumn`, `DateColumn`, `TimeColumn`, `DateTimeColumn`
- Configurable via `Config`:
    - Define column separator, row separator, column type order, date/time formats
- `Parser` and `Row` support:
    - `extract()` – extracts content into typed `Column<?>` instances
    - `getIterator()` – navigate rows and columns without exposing internal structure
- `Validator` for:
    - Raw/null checks and format enforcement
- Custom exceptions:
    - Meaningful feedback on parsing and configuration issues

---

## Technologies

- Java 17
- Maven
- Lombok (for annotations and reduced boilerplate)
