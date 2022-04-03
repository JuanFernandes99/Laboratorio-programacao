import React from "react";
import "../ComponentesCSS/grid.css";

export function Grid() {
  return (
    <div>
      <div className="info">
        <h2>Grid Elements</h2>
        <p>This was done using a grid layout</p>
      </div>
      <div className="grid-container">
        <div className="grid-item">1</div>
        <div className="grid-item">2</div>
        <div className="grid-item">3</div>
        <div className="grid-item">4</div>
        <div className="grid-item">5</div>
        <div className="grid-item">6</div>
        <div className="grid-item">7</div>
        <div className="grid-item">8</div>
        <div className="grid-item">9</div>
      </div>
    </div>
  );
}
