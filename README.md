# SI_2024_lab2_215018
Доне Донев 215018

CONTROL FLOW GRAPH

<img width="495" alt="SILab2_b2" src="https://github.com/DoneDonev/SI_2024_lab2_215018/assets/108617879/ed8fd450-835f-4734-b843-3231101899c4">




ЦИКЛОМАТСКА КОМПЛЕКСНОСТ

Цикломатската комплексност на дадениот код е 10, резултатот го добив според формулата P+1, каде P е бројот на предикатни јазли. Во овој случај P=9, па цикломатската комплексност изнесува 10.
Истиот резултат може и да се добие со формулата E - N + 2P, каде E ми е бројот на ребра a N ми е бројот на јазли, P ми е колку поврзани компоненти имам, во случајов имам 40 ребра и 32 јазли
со една поврзана компонента, така добив 40 - 32 +(2*1) = 10.



ТЕСТ СЛУЧАИ СПОРЕД КРИТЕРИУМОТ EVERY BRANCH

Test Case1: AllItems == null, payment = anything
 -Проверува дали методот правилно фрла исклучок кога листата "allItems" е null.
 -Очекуван излез: RuntimeException "allItems list can't be null!"

Test Case2: AllItems == [(“Item1”, “1234”, 50, 0)], payment = 125
 -Проверува дали методот правилно пресметува сумата кога има еден предмет со валиден баркод и без попуст.
 -Очекуван излез: true (сумата е 50 и е помала или еднаква на payment)

Test Case3: AllItems == [(“Item2”, “1286”, 200, 0.1)], payment = 190
 -Проверува дали методот правилно пресметува сумата кога има еден предмет со валиден баркод и со попуст.
 -Очекуван излез: true (сумата е 200 * 0.1 = 20 и е помала или еднаква на payment)

Test Case4: AllItems == [(“Item3”, “12g3”, 200, 0)], payment = 230
 -Проверува дали методот правилно фрла исклучок кога баркодот содржи невалиден карактер.
 -Очекуван излез: RuntimeException "Invalid character in item barcode!"

Test Case5: AllItems == [(“Item4”, null, 90, 0)], payment = 100
 -Проверува дали методот правилно фрла исклучок кога баркодот е null.
 -Очекуван излез: RuntimeException "No barcode!"

Test Case6: AllItems == [(“Item5”, “01283”, 320, 0.6)], payment = 320
 -Проверува дали методот правилно пресметува сумата кога предметот има цена над 300, 
  попуст и баркод што почнува со '0', при што се применува дополнителен попуст од 30.
 -Очекуван излез: true

Test Case7: AllItems == [(null, “1226”, 220, 0)],  payment = 190
 -Проверува дали методот правилно ги поставува имињата на предметите на "unknown" кога тие се null.
  и пресметка на сумата кога payment е помал од сумата за плаќање.
 -Очекуван излез: false
 

Every Branch		Test Case1		Test Case2		Test Case3		Test Case4		Test Case5		Test Case6		Test Case7
1 – 2			*			*			*			*			*			*			*
2 – 3			*			
2 – 4						*			*			*			*			*			*
3 – 28			*										
4 – 5.1						*			*			*			*			*			*
5.1 – 5.2					*			*			*			*			*			*
5.2 – 6						*			*			*			*			*			*
5.2 – 26					*			*									*			*
6 – 7						*			*			*			*			*			*
7 – 8																					*
7 – 9						*			*			*			*			*
8 – 9																					*
26 – 27																					*
26 – 28						*			*									*
27 – 28																					*
9 – 21															*
21 – 22															*
22 – 28															*
9 – 10						*			*			*						*			*
10 – 11						*			*			*						*			*
11 – 12.1					*			*			*						*			*
12.1 – 12.2					*			*			*						*			*
12.2 – 13					*			*			*						*			*
12.2 – 17																				*
13 – 14						*			*			*						*			*
14 – 15												*
15 – 28												*						
14 – 16						*			*									*			*
16 – 12.3					*			*									*			*
12.3 – 12.2					*			*									*			*
17 – 18									*									*			*
17 – 19						*
19 – 20						*
20 – 23																					
18 – 23						*			*									*			*
23 – 24																		*
23 – 25									*
24 – 25																		*
25 – 5.3					*			*									*			*
5.3 – 5.2					*			*									*			*



ОБЈАСНУВАЊЕ НА НАПИШАНИТЕ UNIT TESTS

СПОРЕД КРИТЕРИУМОТ EVERY BRANCH
Test Case1: AllItems == null, payment = anything
ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, 5));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));
Објаснување: Методот треба да фрли exception кога листата на предмети е null.

Test Case2: AllItems == [(“Item1”, “1234”, 50, 0)], payment = 125
assertTrue(SILab2.checkCart(createList(new Item("Item1", "1234", 50, 0)), 125));
Објаснување: Методот треба правилно да ја пресмета сумата за еден предмет без попуст и да врати true бидејќи 50 <= 125.

Test Case3: AllItems == [(“Item2”, “1286”, 200, 0.1)], payment = 190
assertTrue(SILab2.checkCart(createList(new Item("Item2", "1286", 200, 0.1F)), 190));
Објаснување: Методот треба правилно да ја пресмета сумата за еден предмет со попуст и да врати true, така што 200*0.1 = 20 а 20 <= 190

Test Case4: AllItems == [(“Item3”, “12g3”, 200, 0)], payment = 230
ex = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(createList(new Item("Item3", "12g3", 200, 0)), 230));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));
Објаснување: Овде методот треба да фрли exception од типот "Invalid character in item barcode!", бидејќи имаме невалиден карактер во баркодот.

Test Case5: AllItems == [(“Item4”, null, 90, 0)], payment = 100
ex = assertThrows(RuntimeException.class,
                () -> SILab2.checkCart(createList(new Item("Item4", null, 90, 0)), 100));
        assertTrue(ex.getMessage().contains("No barcode!"));
Објаснување: Овде методот треба да фрли exception од типот "No Barcode!", бидејќи немаме баркод внесено или баркодот е null.

Test Case6: AllItems == [(“Item5”, “01283”, 320, 0.6)], payment = 320
assertTrue(SILab2.checkCart(createList(new Item("Item5", "01283", 320, 0.6F)), 320));
Објаснување: Овој тест ни слижи само за да помине низ гранките во кои ќе има и дополнителен попуст и затоа треба да врати true.

Test Case7: AllItems == [(null, “1226”, 220, 0)],  payment = 190
assertFalse(SILab2.checkCart(createList(new Item(null, "1226", 220, 0)), 190));
Објаснување: Овој тест ни служи за да поминеме низ гранката во која ке го сетира името на продкутот на "unknown" бидејќи немаме име внесено или должината на името е 0, но ќе ни врати false бидејќи 220 не е <=190 односно плаќаме помалку одколку што ни се бара во сумата.
