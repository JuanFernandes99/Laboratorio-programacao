import "./App.css";
import { HeaderTeste } from "./ComponentesJS/header.js";
import { Grid } from "./ComponentesJS/grid.js";
import { Tabela } from "./ComponentesJS/table.js";
import { Footer } from "./ComponentesJS/footer.js";
import { Counter } from "./ComponentesJS/counter.js";
function App() {
  return (
    <div className="App">
      <div>
        <HeaderTeste></HeaderTeste>
      </div>
      <div className="float">
        <div>
          <Grid></Grid>
        </div>
        <div>
          <Tabela></Tabela>
        </div>
      </div>
      <div>
        <Counter></Counter>
      </div>
      <div>
        <Footer></Footer>
      </div>
    </div>
  );
}

export default App;
