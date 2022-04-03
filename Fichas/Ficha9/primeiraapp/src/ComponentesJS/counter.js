import React from "react";
import "../ComponentesCSS/counter.css";
import { useState } from "react";

export function Counter() {
  const [counter, setCounter] = useState(10);

  return (
    <div className="CounterTeste">
      <h1>React Counter</h1>
      <p className="contagem">{counter} </p>
      <br></br>
      <button onClick={() => setCounter(counter + 1)}>+</button>
      <button onClick={() => setCounter(counter - 1)}>-</button>
    </div>
  );
}
