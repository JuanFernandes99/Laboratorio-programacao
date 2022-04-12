import { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";
import InputLabel from "@mui/material/InputLabel";
import Button from "@mui/material/Button";
import "./addPessoa.css";
export function Pessoa(props) {
  const API_URL = "http://localhost:8080";
  const [mensagem, setNovaMensagem] = useState();
  const [sucess, setSucess] = useState(true);
  const [showImage, SetShowImage] = useState(false);
  const [mensagemErro, setNovaMensagemErro] = useState();
  const [listaEmpresas, setListasEmpresa] = useState([]);
  const [novaPessoa, setNovaPessoa] = useState({
    nome: "",
    idade: "",
    morada: "",
    email: "",
    imagem: "",
    empresa: {},
  });

  useEffect(() => {
    GetEmpresas();
  }, []);
  function AdicionarPessoa() {
    fetch(API_URL + "/addPessoa", {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(novaPessoa),
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

  const uploadImage = async (e) => {
    const file = e.target.files[0];
    console.log(file);
    const base64 = await convertBase64(file);
    setNovaPessoa({ ...novaPessoa, imagem: base64 });
  };

  const convertBase64 = (file) => {
    return new Promise((resolve, reject) => {
      const fileReader = new FileReader();
      fileReader.readAsDataURL(file);

      fileReader.onload = () => {
        resolve(fileReader.result);
      };

      fileReader.onerror = (error) => {
        reject(error);
      };
    });
  };

  function GetEmpresas() {
    fetch(API_URL + "/getAllEmpresas", {
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
        setListasEmpresa(parsedResponse);
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
          id="filled-basic"
          label="Nome da Pessoa"
          variant="filled"
          type="text"
          value={novaPessoa.nome}
          onChange={(e) => {
            setNovaPessoa({ ...novaPessoa, nome: e.target.value });
          }}
        />
        <TextField
          margin="normal"
          required
          id="filled-basic"
          label="idade da Pessoa"
          variant="filled"
          type="text"
          value={novaPessoa.idade}
          onChange={(e) => {
            setNovaPessoa({ ...novaPessoa, idade: e.target.value });
          }}
        />
        <TextField
          margin="normal"
          required
          id="filled-basic"
          label="morada da Pessoa"
          variant="filled"
          type="text"
          value={novaPessoa.morada}
          onChange={(e) => {
            setNovaPessoa({ ...novaPessoa, morada: e.target.value });
          }}
        />
        <TextField
          margin="normal"
          required
          id="filled-basic"
          label="email da Pessoa"
          variant="filled"
          type="text"
          value={novaPessoa.email}
          onChange={(e) => {
            setNovaPessoa({ ...novaPessoa, email: e.target.value });
          }}
        />
        <Button variant="contained" component="label">
          Selecionar imagem da Pessoa
          <input
            type="file"
            hidden
            variant="filled"
            required
            onChange={(e) => {
              uploadImage(e);
              SetShowImage(true);
            }}
          />
        </Button>
        {showImage ? (
          <div>
            <p>imagem selecionada: </p>
            <img src={novaPessoa.imagem} alt="pessoaimagem" />
          </div>
        ) : (
          <p>{"Nenhum ficheiro escolhido"}</p>
        )}

        <br></br>
        <FormControl>
          <InputLabel id="demo-simple-select-label">Empresa</InputLabel>
          <Select
            labelId="Empresa"
            id="filled-basicc"
            label="Empresa"
            value={novaPessoa.empresa}
            onChange={(e) => {
              setNovaPessoa({ ...novaPessoa, empresa: e.target.value });
            }}
          >
            {listaEmpresas.map((element) => (
              <MenuItem value={element} key={element.id}>
                {element.nome}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </Box>

      <Button onClick={AdicionarPessoa}>Adicionar Pessoa</Button>
      {sucess ? <p>{mensagem}</p> : <p>{mensagemErro}</p>}
    </>
  );
}
