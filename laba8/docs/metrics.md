# Метрики CBO та LCOM4 (варіант 6, Java)

## CBO - кількість інших класів проєкту, з якими пов'язаний даний клас

| Клас | До змін | Після | Зв'язки "після" |
| `LegacyRestaurantProcessor` → `ReservationController` | 5 | **4** | `ReservationFactory`, `ReservationRepository`, `ReservationRequest`, `TableReservation` |
| `TableReservation` | 4 (`Guest`, `OrderLine`, `List`, `ArrayList`) | **4** | `Guest`, `OrderLine`, `TimeSlotPolicy`, `List` |
| `OrderLine` | 1 (`MenuItem`) | **1** | `MenuItem` |
| `ConsoleApp` (UI, нормативу немає) | — | 9 | композиція залежностей (composition root) |

Legacy-процесор: `Scanner`, `Guest`, `TableReservation`, `MenuItem`, `OrderLine` = 5.

**Висновок:** ключові доменні сутності й контролер мають CBO ≤ 4. Зачеплення з консоллю, файлом, SMS і форматуванням винесено на периферію (інтерфейси та UI) і не навантажують основні доменні сутності та контролер.

## LCOM4 - вимірює кількість непов'язаних груп методів усередині класу

| Клас | До | Після | Пояснення |
| `LegacyRestaurantProcessor` | 1 (формально, один метод-"god-method" з 7+ обов'язками) | — | розбито на 8 класів |
| `TableReservation` | 0 (немає методів) | **1** | `foodSubtotal`, `serviceCharge` (викликає `foodSubtotal`), `totalBill` (викликає обидва) — одна компонента |
| `OrderLine` | 0 | **1** | єдиний метод `subtotal` |
| `ReservationController` | — | **1** | один метод `reserve` |
| `ReservationFactory` | — | **1** | один метод `create` |
| `FileReservationRepository` | — | **1** | один метод `save` |
| `ReservationReceiptFormatter` | — | **1** | один метод `format` |

**Висновок:**  усі розроблені класи мають ідеальну згуртованість (LCOM4 = 1), оскільки кожен із них виконує чітко один обов'язок за патерном Single Responsibility. Може бути ситуація коли декілька методів викликають один одного і працюють над спільною метою - тоді вони утворюють зв'язну компоненту.

