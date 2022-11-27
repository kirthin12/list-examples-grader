# Create your grading script here

set -e

rm -rf student-submission
git clone $1 student-submission

score = 0
compile = ".:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar"
cd student-submission

if [ -f ListExamples.java ]
then
    echo "FILE FOUND"
    score = 1
else
    echo "FILE NOT FOUND"
    exit 1
fi

cd ../
cp -rf lib student-submission
cp -f TestListExamples.java student-submission

cd student-submission

javac -cp $compile *.java


if [[ $? -eq 0 ]]
then
  echo "COMPILED"
  SCORE = 2
else
  echo "DID NOT COMPILE"
  exit 1
fi

jjava -cp $compile org.junit.runner.JUnitCore TestListExamples > score.txt

grep -q "2 tests" score.txt
if [[ $? -eq 0 ]]; then
    SCORE=4
fi
grep -q "1 tests" score.txt
if [[ $? -eq 0 ]]; then
    SCORE=3
fi
grep -q "0 tests" score.txt
if [[ $? -eq 0 ]]; then
    SCORE=2
fi

echo "Your score is  $score/4"
