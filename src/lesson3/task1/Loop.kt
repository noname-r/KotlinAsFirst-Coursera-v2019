@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import lesson5.task1.whoAreInBoth
import lesson6.task1.plusMinus
import kotlin.math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result *= i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun digitNumber(n: Int): Int {
    var counter = 0
    var i = 1L
    while (i <= n) {
        counter++
        i *= 10
        println(i)
    }
    if (n == 0) return 1 else return counter
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
//fun fib(n: Int): Int {
//    var sumPrev = 0
//    var sum = 1
//    var sumNext = 0
//    if (n == 1) return 1
//    for (i in 2..n) {
//        sumNext = sumPrev + sum
//        sumPrev = sum
//        sum = sumNext
//    }
//    return sumNext
//}

fun fib(n: Int): Int =
    if (n in 1..2) 1 else fib(n - 1) + fib(n - 2)

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */

fun lcm(m: Int, n: Int): Int {
    var a = m
    var b = n
    if (a > b) {
        a = n
        b = m
    }
    var count = 1
    while ((b * count) % a != 0) count++
    return b * count
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var count = 2
    while (n % count != 0) count++
    return count
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var count = 2
    while (n % (n / count) != 0) count++
    return n / count
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    if ((n < 2) || (n < 2)) return false
    if ((m == 2) || (n == 2)) return true
    if ((m % 2 == 0) && (n % 2 == 0)) return false
    for (i in 3..sqrt(m.toDouble()).toInt() step 2) {
        if (m % i == 0) {
            if (n % i == 0) {
                return false
            }
        }
    }
    return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    for (i in m..n) {
        if (sqrt(i.toDouble()) == sqrt(i.toDouble()).toInt().toDouble()) return true
    }
    return false
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var nextX = x
    var count = 0
    while (nextX != 1) {
        if (nextX % 2 == 0) nextX /= 2
        else nextX = 3 * nextX + 1
        count++
    }
    return count
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * a := a * (-1) * x * x / ((i - 1) * i);
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double = TODO()
/*
{
    var result = x
    var mult = -1
    var count = 3
    var next = 0.0
    println(eps)
    do  {
        next = mult*x.pow(count)/(count-1)*count
        println(next)
        println(next.absoluteValue)
        result += next
        mult *= -1
        count += 2
    } while (next.absoluteValue >= eps)
    return result
}
*/

fun main() {
    sin(PI / 2.0, 1e-5)
}
/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var _n = n
    var result = 0
    while (_n > 0) {
        result = result * 10 + _n % 10
        _n /= 10
    }
    return result
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    var _n = n
    var first = 0
    var count = 0
    while (_n > 0) {
        _n = _n / 10
        count++
    }
    _n = n
    while (count > 1) {
        first = (_n / (10.0.pow(count - 1)).toInt()) % 10
        if (first != _n % 10) return false
        _n = _n % (10.0.pow(count - 1)).toInt() / 10
        count -= 2
    }
    return true
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var prev = n % 10
    var _n = n / 10
    while (_n > 0) {
        if (prev != _n % 10) return true
        _n /= 10
    }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
    var num = 0
    var count = 0
    while (count < n) {
        num++
        when (num * num) {
            in 1..9 -> count += 1
            in 10..99 -> count += 2
            in 100..999 -> count += 3
            in 1000..9999 -> count += 4
        }
    }
    var lastSqr = num * num
    while (count != n) {
        lastSqr /= 10
        count--
    }
    return lastSqr % 10
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var num = 0
    var count = 0
    while (count<n) {
        num++
        when (fib(num)) {
            in 1..9 -> count += 1
            in 10..99 -> count += 2
            in 100..999 -> count += 3
            in 1000..9999 -> count += 4
        }
    }
    var lastSqr = fib(num)
    while (count != n) {
        lastSqr /= 10
        count--
    }
    return lastSqr % 10
}

