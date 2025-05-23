// # **Тип данных `byte` в Java: подробный разбор**

// ## **1. Введение**
// Тип `byte` в Java — это 8-битный целочисленный примитивный тип данных, 
// который используется для хранения небольших числовых значений.
// Он занимает **1 байт (8 бит)** памяти и может представлять числа в диапазоне от **-128 до 127**.  

// ### **Основные характеристики:**
// - Размер: **8 бит (1 байт)**
// - Диапазон: **-128 до 127**
// - Значение по умолчанию: **0**
// - Применение: экономия памяти, работа с бинарными данными (файлы, сетевые пакеты)

// ---

// ## **2. Объявление и инициализация**
// ### **2.1. Синтаксис объявления**
// ```java
// byte variableName = value;
// ```
// Пример:
// ```java
// byte age = 25;
// byte temperature = -10;
// ```

// ### **2.2. Особенности инициализации**
// - Если присвоить значение **>127** или **<-128**, будет ошибка компиляции:
//   ```java
//   byte errorByte = 130; // Ошибка: incompatible types (требуется явное приведение)
//   ```
// - Можно использовать явное приведение (`casting`), но это может привести к потере данных:
//   ```java
//   byte forcedByte = (byte) 130; // Результат: -126 (из-за переполнения)
//   ```

// ---

// ## **3. Арифметические операции и переполнение**
// ### **3.1. Арифметика с `byte`**
// При выполнении операций (`+`, `-`, `*`, `/`) Java автоматически преобразует `byte` в `int`:
// ```java
// byte a = 100;
// byte b = 50;
// byte c = (byte) (a + b); // Без приведения будет ошибка!
// ```
// **Почему?**  
// Арифметические операции в Java выполняются в **32-битном `int`**, поэтому результат нужно явно приводить обратно к `byte`.

// ### **3.2. Переполнение (overflow)**
// Поскольку `byte` имеет ограниченный диапазон, при выходе за границы происходит **циклическое переполнение**:
// ```java
// byte max = 127;
// max++; // Становится -128 (минимальное значение)
// byte min = -128;
// min--; // Становится 127 (максимальное значение)
// ```

// ---

// ## **4. Использование `byte` в массивах и `InputStream`**
// ### **4.1. Массивы `byte[]`**
// Используются для работы с бинарными данными (например, чтение файлов):
// ```java
// byte[] buffer = new byte[1024]; // Буфер на 1 КБ
// ```

// ### **4.2. Чтение данных (`InputStream`)**
// Метод `read()` возвращает `byte` или `-1` (конец потока):
// ```java
// try (InputStream input = new FileInputStream("file.txt")) {
//     byte data;
//     while ((data = (byte) input.read()) != -1) {
//         System.out.print(data);
//     }
// }
// ```

// ---

// ## **5. Сравнение с другими целочисленными типами**
// | Тип      | Размер (бит) | Диапазон               | Использование                          |
// |----------|--------------|------------------------|----------------------------------------|
// | `byte`   | 8            | -128..127              | Экономия памяти, бинарные операции     |
// | `short`  | 16           | -32_768..32_767        | Редко используется                     |
// | `int`    | 32           | -2³¹..2³¹-1 (~2 млрд)  | Основной тип для целых чисел           |
// | `long`   | 64           | -2⁶³..2⁶³-1            | Большие числа                          |

// **Когда использовать `byte`?**
// - При работе с **файлами, сетевыми пакетами** (например, `byte[]` в `FileInputStream`).
// - В **массивах**, где важна экономия памяти.
// - В **низкоуровневых операциях** (битовые сдвиги, маски).

// ---

// ## **6. Битовая арифметика с `byte`**
// Тип `byte` поддерживает **битовые операции** (`&`, `|`, `^`, `~`, `<<`, `>>`, `>>>`):
// ```java
// byte flags = 0b00101100; // Двоичный формат (44 в десятичной)
// byte masked = (byte) (flags & 0b00001111); // Маскирование (результат: 12)
// ```

// ### **Пример: извлечение цветов из RGB**
// ```java
// int rgb = 0xFFAABBCC;
// byte red = (byte) ((rgb >> 16) & 0xFF);   // Красный канал
// byte green = (byte) ((rgb >> 8) & 0xFF);  // Зеленый канал
// byte blue = (byte) (rgb & 0xFF);          // Синий канал
// ```

// ---

// ## **7. Автоупаковка (`Byte`)**
// Java автоматически преобразует `byte` в объект `Byte` (автоупаковка) и обратно:
// ```java
// Byte objByte = 100; // Автоупаковка
// byte primByte = objByte; // Автораспаковка
// ```

// **Кэширование `Byte`:**
// Как и `Integer`, `Byte` кэширует значения **от -128 до 127**:
// ```java
// Byte a = 100;
// Byte b = 100;
// System.out.println(a == b); // true (один и тот же кэшированный объект)
// ```

// ---

// ## **8. Выводы**
// - `byte` — **самый маленький целочисленный тип** (8 бит).
// - **Диапазон**: от **-128** до **127**.
// - **Основное применение**: работа с бинарными данными, экономия памяти.
// - **Арифметика требует приведения** (т.к. операции выполняются в `int`).
// - **Переполнение** циклическое (127 + 1 = -128).
// - Поддерживает **битовые операции**.
// - Имеет объектный аналог — **`Byte`** (с автоупаковкой).

// ### **Когда использовать?**
// ✅ Для **массивов байт** (например, при чтении файлов).  
// ✅ В **низкоуровневых операциях** (битовые маски, шифрование).  
// ✅ Когда критична **экономия памяти** (большие массивы чисел в диапазоне -128..127).  

// ### **Когда не использовать?**
// ❌ Для обычных вычислений (лучше `int` или `long`).  
// ❌ Если нужен больший диапазон (используйте `short` или `int`).  

// ---
// **Итог:** `byte` — важный тип для работы с бинарными данными,
// но в обычной арифметике используется редко из-за малого диапазона и необходимости приведения типов.