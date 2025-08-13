# 30 Days of Mountain Hikes

An Android app built with **Kotlin** and **Jetpack Compose** that takes users through a **30-day mountain hiking journey**.  
Each day presents a unique hiking route with beautiful images, difficulty levels, mountain names, and optional expanded descriptions.

This project puts into practice core **Compose UI concepts** such as state management, theming, animations, and custom layouts to create an interactive and visually engaging experience.

---

## Features

- **Daily Hike Cards** – Browse 30 unique hiking destinations, each with an image and day number.
- **Animated Mountain Level & Name** – Tap to toggle between difficulty level and mountain name with smooth transitions.
- **Expandable Descriptions** – Reveal more hike details on demand.
- **Quick Navigation** – Floating action buttons to instantly jump to the start or end of the list.
- **Finish Screen** – Special celebratory medal screen for Day 30.
- **Expandable Social Media Sidebar** – Logos of popular platforms (links not yet included).
- **Material 3 Styling** – Consistent colors, typography, and shape theming.
- **Interactive Animations** – Uses `AnimatedContent` and `AnimatedVisibility` for a polished, dynamic feel.

---

## Implementation details

This app applies several key **Kotlin and Jetpack Compose concepts**:

- **Composable Functions** – Modular UI elements for better reusability and readability.
- **State and Recomposition** – Managed with `remember` and `mutableStateOf` for dynamic UI updates.
- **Layouts and Modifiers** – Combining `Column`, `Row`, `Box`, and modifiers for precise positioning and styling.
- **Lazy Lists** – `LazyColumn` for efficient scrollable lists.
- **Material 3 Components** – Modern Android UI design using Material 3’s `Scaffold`, `TopAppBar`, `Card`, and `FloatingActionButton`.
- **Resource Management** – Using `painterResource` and `stringResource` to load images and text from resources.
- **Animation APIs** – Smooth transitions with `AnimatedContent` and expand/collapse effects via `AnimatedVisibility`.
- **Coroutines in Compose** – Using `rememberCoroutineScope` with scrolling actions.

---

## Main Components

- **`DaysApp()`** – Main screen which contains a scaffold, where there is a top bar, content list, and sidebar.
- **`DaysList()`** – Scrollable list (LazyColumn) of hikes with quick navigation controls.
- **`HikeCard()`** – Displays each hike’s image, title, and detailed info.
- **`AnimatedMountainLevel()`** – Switches between hike difficulty and mountain name, circularly.
- **`AnimatedInfo()`** – Expandable hike description section.
- **`Sidebar()`** – A sidebar with social media logos (could be extended to include actual social-media links).
- **`Finish()`** – Special end-of-journey image and text for Day 30.

---

## Screenshots

**Light theme**  
<img src="screenshots/light_theme.png" alt="Light theme" width="300"/>

**Dark theme**  
<img src="screenshots/dark_theme.png" alt="Dark theme" width="300"/>

**Light theme expanded**  
<img src="screenshots/light_theme_details.png" alt="Light theme expanded" width="300"/>