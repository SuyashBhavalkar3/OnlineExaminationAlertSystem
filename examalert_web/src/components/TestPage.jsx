// src/components/TestPage.jsx
import React, { useState } from 'react';

const TestPage = () => {
    const questions = [
        {
          id: 1,
          question: 'What is the value of 7 × 8?',
          options: ['54', '56', '58'],
          answer: '56'
        },
        {
          id: 2,
          question: 'Solve: (3 + 5) × 2',
          options: ['13', '16', '20'],
          answer: '16'
        },
        {
          id: 3,
          question: 'What is the square root of 81?',
          options: ['9', '8', '7'],
          answer: '9'
        }
      ];
      

  const [currentIndex, setCurrentIndex] = useState(0);
  const [score, setScore] = useState(0);
  const [finished, setFinished] = useState(false);

  const handleAnswer = (selected) => {
    if (selected === questions[currentIndex].answer) {
      setScore(score + 1);
    }
    const nextIndex = currentIndex + 1;
    if (nextIndex < questions.length) {
      setCurrentIndex(nextIndex);
    } else {
      setFinished(true);
    }
  };

  return (
    <>
    <div className="container mt-5">
      {!finished ? (
        <div className="card p-4 shadow">
          <h4>{questions[currentIndex].question}</h4>
          <div className="mt-3">
            {questions[currentIndex].options.map((option, idx) => (
              <button
                key={idx}
                onClick={() => handleAnswer(option)}
                className="btn btn-outline-primary m-2"
              >
                {option}
              </button>
            ))}
          </div>
        </div>
      ) : (
        <div className="card p-4 shadow text-center">
          <h4>Test Completed</h4>
          <p>Your Score: {score} / {questions.length}</p>
        </div>
      )}
    </div>
    </>
  );
};

export default TestPage;
