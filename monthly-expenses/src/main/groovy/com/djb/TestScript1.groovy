/**
 * Created by dblau on 1/31/16.
 */
package com.djb

Department dpt1 = new Department()
assert dpt1.getMonthlyAllocationExpense() == 0f
Manager m1 = new Manager()
Manager m2 = new Manager()
dpt1.addManager(m1)
m1.addEmployee(m2)

QATester q1 = new QATester()
m2.addEmployee(q1)
Developer d1 = new Developer()
m2.addEmployee(d1)
Manager m3 = new Manager()
m2.addEmployee(m3)
QATester q2 = new QATester()
QATester q3 = new QATester()
Developer d2 = new Developer()
Developer d3 = new Developer()
Developer d4 = new Developer()
Developer d5 = new Developer()
m3.addEmployee(q2)
m3.addEmployee(q3)
m3.addEmployee(d2)
m3.addEmployee(d3)
m3.addEmployee(d4)
m3.addEmployee(d5)

println dpt1.getMonthlyAllocationExpense()
println m1.getMonthlyAllocationExpense()
println m2.getMonthlyAllocationExpense()
println m3.getMonthlyAllocationExpense()
println q1.getMonthlyAllocationExpense()
println q2.getMonthlyAllocationExpense()
println q3.getMonthlyAllocationExpense()
println d1.getMonthlyAllocationExpense()
println d2.getMonthlyAllocationExpense()
println d3.getMonthlyAllocationExpense()
println d4.getMonthlyAllocationExpense()
println d5.getMonthlyAllocationExpense()