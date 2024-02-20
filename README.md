# Bitcoin Price Android App

This Android app displays the current price of Bitcoin. It follows the MVVM architecture pattern and uses XML for the UI layout.

## Features

- **User Interface:** Built with XML
- **Architecture:** MVVM (Model-View-ViewModel) with XML for UI.
- **Navigation:** Single-activity architecture using Navigation Compose.
- **Presentation Layer:** Contains an XML layout (View) and a ViewModel per screen/feature.
- **Reactive UIs:** Uses Flow and coroutines for asynchronous operations.
- **Data Layer:** Includes a repository and two data sources (local using Room and a fake remote).
- **Testing:** Includes unit, integration, and end-to-end tests, including "shared" tests for emulator/device.
- **Product Flavors:** Includes mock and prod flavors for development and testing.
- **Dependency Injection:** Uses Hilt for dependency injection.

## Screenshot



<img width="342" alt="Screenshot 2024-02-19 at 23 01 59" src="https://github.com/EYMR/BitcoinPrice/assets/99291449/34b99eb0-966e-496e-9ac1-025cad5ec11c">
