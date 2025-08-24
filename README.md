# Assignment 01: Currency Converter using JavaFX and SceneBuilder

## Problem Statement
Design a simple Currency Converter application with **two scenes**:

- **Scene 1 (Main Converter Scene)**: Allows the user to input an amount, select currencies to convert from and to, perform the conversion, and see the result.  
- **Scene 2 (History Scene)**: Displays a table of previous conversions.

---

## Requirements

### Scene 1: Main Converter Interface
- **TextField** for entering the amount.
- **ComboBox** for selecting the "From" currency.
- **ComboBox** for selecting the "To" currency.
- **Button: Convert**
  - Performs the conversion based on selected currencies.
  - Displays the result in a Label.
- **Button: View History**
  - Switches to the history scene.

### Scene 2: Conversion History View
- **TableView** with 4 columns: `From`, `To`, `Amount`, `Result`.
- **Button: Back**
  - Returns to the main converter scene.

---

## Validations
1. The **amount field** must not be empty and must contain valid numeric data.
2. Both currency selections must be made before conversion.
3. If validation fails, show an **error message** in the result label.

---

## Conversion Logic
1. Use a **shared ObservableList** to store all conversion entries:
   ```java
   ObservableList<CurrencyConversion> history = FXCollections.observableArrayList();
