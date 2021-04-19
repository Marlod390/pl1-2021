/**
Homework 01
============
Before doing anything else, register for the Programmiersprachen 1 exercises
by sending an email to Marius Müller:

mari.mueller@uni-tuebingen.de

Write in the email:
- name
- Matrikelnummer
- Studiengang + Abschluss (BSc, MSc, ...)
- Fachsemester
- name of your GitHub account (register under github.com if you do not have one yet)
- optionally: programming languages you already know

You will receive an invitation to our forum for Programmiersprachen 1.
In the "Organisatorisches" post you will find everything necessary
to get you started. Read that post first and follow the instructions.

In particular, in that post you will find an invitation to the GitHub Education
platform for Programmiersprachen 1 exercises.

Work in groups of 1 or 2 students.
If you want to work together with another student,
have one of you create a team (you will be asked
to create or join a team by default) and the other
then join that team.

If you have any questions regarding these processes,
just ask in the forum beneath the "Organisatorisches" post.

Submit your solution to this exercise until Friday, 23.04., 10:00h
via the GitHub repo for your team and for this exercise.
*/

object Hw01 {

/**
Consider the following language of propositional logic formulae:
*/
sealed abstract class Exp
case class True() extends Exp  // constant true
case class False() extends Exp // constant false
case class And(lhs: Exp, rhs: Exp) extends Exp
case class Or(lhs: Exp, rhs: Exp) extends Exp
case class Not(e: Exp) extends Exp
case class Impl(lhs: Exp, rhs: Exp) extends Exp

/**
Tasks:
       1) Implement the missing parts of the interpreter for these formulae
          (the eval function).
          Test the correctness by evaluating the example proposition given
          below and add at least two more examples and test against these.
       2) Add implication as a new kind of expression "Impl" and extend
          the interpreter accordingly. Add at least two examples and test.
*/

def eval(e: Exp) : Boolean = e match {
  case True()    => true
  case False()   => false
  case And(l, r) => eval(l) && eval(r)
  case Or(l, r)  => eval(l) || eval(r)
  case Not(e)    => !eval(e)
  case Impl(s,f) => !eval(s) || eval(f)
}

val exampleProposition = And(Not(True()), False()) // should evaluate to false
val test1= Or(False(),True())// examples for test 1,should evaluate to true 
val test2= Or(False(),Not(True()))// examples for test 2,should evaluate to false
val impltest1 = Impl(Or(True(),False()), And(True(),False()))// examples for test implication 1,should evaluate to false
val impltest2 = Impl(And(True(),False()), Or(True(),False()) )// examples for test implication 1,should evaluate to true
def main(args: Array[String]) : Unit = {
  println(eval(exampleProposition))
  println(eval(test1))
  println(eval(test2))
  println(eval(impltest1))
  println(eval(impltest2))
}

}
