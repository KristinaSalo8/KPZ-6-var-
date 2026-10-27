# Метрики CBO та LCOM4 (варіант 6, Java)

**Домовленості підрахунку** (за методичкою): рахуються типи з полів, параметрів, значень, що повертаються, локальних змінних і викликів.
Примітиви та `java.lang.*` не рахуються; `java.util.*` (`Scanner`, `List`) рахуються як інфраструктурні.
LCOM4: тривіальні accessor-и (`id()`, `guestName()` ...) виключені, як дозволяє методичка. Підрахунок ручний — перевірте інструментом (наприклад, CKJM, MetricsReloaded) перед захистом.

## CBO

| Клас | До рефакторингу | Після | Зв'язки "після" |
|---|---|---|---|
| `LegacyRestaurantProcessor` → `ReservationController` | 5 | **4** | `ReservationFactory`, `ReservationRepository`, `ReservationRequest`, `TableReservation` |
| `TableReservation` | 4 (`Guest`, `OrderLine`, `List`, `ArrayList`) | **4** | `Guest`, `OrderLine`, `TimeSlotPolicy`, `List` |
| `OrderLine` | 1 (`MenuItem`) | **1** | `MenuItem` |
| `ConsoleApp` (UI, нормативу немає) | — | 9 | композиція залежностей (composition root) |

Legacy-процесор: `Scanner`, `Guest`, `TableReservation`, `MenuItem`, `OrderLine` = 5.

**Висновок:** ключові доменні сутності й контролер мають CBO ≤ 4. Зачеплення з консоллю, файлом, SMS і форматуванням винесено на периферію (інтерфейси та UI).

## LCOM4

| Клас | До | Після | Пояснення |
|---|---|---|---|
| `LegacyRestaurantProcessor` | 1 (формально, один метод-"god-method" з 7+ обов'язками) | — | розбито на 8 класів |
| `TableReservation` | 0 (немає методів) | **1** | `foodSubtotal`, `serviceCharge` (викликає `foodSubtotal`), `totalBill` (викликає обидва) — одна компонента |
| `OrderLine` | 0 | **1** | єдиний метод `subtotal` |
| `ReservationController` | — | **1** | один метод `reserve` |
| `ReservationFactory` | — | **1** | один метод `create` |
| `FileReservationRepository` | — | **1** | один метод `save` |
| `ReservationReceiptFormatter` | — | **1** | один метод `format` |

**Висновок:** усі нові класи мають LCOM4 = 1 (одна відповідальність). Формальний LCOM4 legacy-процесора = 1 лише через єдиний метод; реальна проблема — багато обов'язків у ньому: ввід, створення, розрахунок, форматування, збереження, сповіщення.
