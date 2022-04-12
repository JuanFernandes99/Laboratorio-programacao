import { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
export function Empresa() {
  const API_URL = "http://localhost:8080";
  const [mensagem, setNovaMensagem] = useState();
  const [sucess, setSucess] = useState(true);
  const [showImage, SetShowImage] = useState(false);
  const [mensagemErro, setNovaMensagemErro] = useState();
  const [novaEmpresa, setNovaEmpresa] = useState({
    nome: "",
    morada: "",
    imagem: "",
  });

  function AdicionarEmpresa() {
    fetch(API_URL + "/addEmpresa", {
      method: "POST",
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(novaEmpresa),
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
    setNovaEmpresa({ ...novaEmpresa, imagem: base64 });
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
          label="Nome da empresa"
          variant="filled"
          type="text"
          value={novaEmpresa.nome}
          onChange={(e) => {
            setNovaEmpresa({ ...novaEmpresa, nome: e.target.value });
          }}
        />
        <TextField
          margin="normal"
          required
          label="Morada da empresa"
          id="filled-basic"
          variant="filled"
          type="text"
          value={novaEmpresa.morada}
          onChange={(e) => {
            setNovaEmpresa({ ...novaEmpresa, morada: e.target.value });
          }}
        />
        <Button variant="contained" component="label">
          Selecionar imagem da Empresa
          <input
            type="file"
            hidden
            variant="filled"
            required
            onChange={(e) => {
              SetShowImage(true);
              uploadImage(e);
            }}
          />
        </Button>
        {showImage ? (
          <div>
            <p>imagem selecionada: </p>
            <img src={novaEmpresa.imagem} alt="empresaimagem" />
          </div>
        ) : (
          <p>{"Nenhum ficheiro escolhido"}</p>
        )}
      </Box>

      <button
        className="btn-editora"
        onClick={() => {
          AdicionarEmpresa();
          // navigate("/getAllEmpresas");
        }}
      >
        Adicionar Empresa
      </button>
      {sucess ? <p>{mensagem}</p> : <p>{mensagemErro}</p>}
    </>
  );
}
