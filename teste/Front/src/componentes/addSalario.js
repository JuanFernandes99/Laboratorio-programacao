import { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import InputLabel from "@mui/material/InputLabel";
import Button from "@mui/material/Button";
import "./addPessoa.css";
export function Salario(props) {
  const API_URL = "http://localhost:8080";
  const [mensagem, setNovaMensagem] = useState();
  const [sucess, setSucess] = useState(true);
  const [mensagemErro, setNovaMensagemErro] = useState();
  const [salario, setNovoSalario] = useState({
    quantidade: "",
    data: "",
    pessoa: {},
  });
  const [listaPessoa, setListasPessoa] = useState([]);

  useEffect(() => {
    GetPessoas();
  }, []);
  function AdicionarSalario() {
    if (
      salario.quantidade.trim().length !== 0 &&
      salario.data.trim().length !== 0
    ) {
      fetch(API_URL + "/addSalario", {
        method: "POST",
        headers: {
          "Content-type": "application/json",
        },
        body: JSON.stringify(salario),
      })
        .then(async (response) => {
          if (response.status !== 200) {
            const parsedResponse = await response.json();
            console.log(parsedResponse.message);
            setNovaMensagemErro(parsedResponse.message);
            setSucess(false);
          }
          console.log(response);
          return response.json();
        })
        .then((parsedResponse) => {
          setNovaMensagem(parsedResponse.message);
          setSucess(true);
        });
    }
  }

  function GetPessoas() {
    fetch(API_URL + "/getAllPessoas", {
      mode: "cors",
      method: "GET",
      headers: {
        "Content-type": "application/json",
      },
    })
      .then((response) => {
        console.log(response);

        if (response.status !== 200) {
          throw new Error("Ocorreu um erro, nenhum Autor disponível");
        }

        return response.json();
      })
      .then((parsedResponse) => {
        console.log(parsedResponse);
        setListasPessoa(parsedResponse);
      })
      .catch((error) => {
        alert(error);
      });
  }

  return (
    <>
      <Box
        component="form"
        sx={{
          marginTop: 8,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
        noValidate
        autoComplete="off"
      >
        <TextField
          margin="normal"
          required
          //falta o width
          id="filled-basic"
          label="quantidade"
          variant="filled"
          type="text"
          value={salario.quantidade}
          onChange={(e) => {
            setNovoSalario({ ...salario, quantidade: e.target.value });
          }}
        />
        <TextField
          margin="normal"
          required
          id="filled-basic"
          label="data do salario"
          variant="filled"
          type="text"
          value={salario.data}
          onChange={(e) => {
            setNovoSalario({ ...salario, data: e.target.value });
          }}
        />
        <FormControl>
          <InputLabel id="demo-simple-select-label">Funcionario</InputLabel>
          <Select
            labelId="Funcionario"
            id="filled-basicc"
            label="Funcionario"
            value={salario.pessoa}
            onChange={(e) => {
              setNovoSalario({ ...salario, pessoa: e.target.value });
            }}
          >
            {listaPessoa.map((element) => (
              <MenuItem value={element} key={element.id}>
                {element.nome}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
        <Button onClick={AdicionarSalario}>Adicionar Salario</Button>
      </Box>
      {sucess ? <p>{mensagem}</p> : <p>{mensagemErro}</p>}
    </>
  );
}
