package br.com.presentes.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.presentes.models.Paciente;
import br.com.presentes.service.PacienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value="Pacientes API")
@RestController
public class PacienteController {
	@Autowired
	PacienteService patientService;
	
	@ApiOperation(value="Consulta de detalhes de um paciente", notes="Consulta síncrona.")
	@GetMapping("/getPatientDetails")
	public Paciente getPatient(@ApiParam(value="nome do paciente")@RequestParam String name) throws InterruptedException, ExecutionException {
		return patientService.getPatientDetails(name);
	}
	
	@ApiOperation(value="Cadastrar novo paciente", notes="Consulta síncrona.")
	@PostMapping("/createPatient")
	public String createPatient(@RequestBody Paciente patient) throws InterruptedException, ExecutionException {
		return patientService.savePatientDetails(patient);
	}

	@ApiOperation(value="Atualizar um paciente", notes="Consulta síncrona.")
	@PutMapping("/updatePatient")
	public String updatePatient(@RequestBody Paciente patient) throws InterruptedException, ExecutionException {
		return patientService.updatePatientDetails(patient);
	}
	
	@ApiOperation(value="Remover um paciente", notes="Consulta síncrona.")
	@DeleteMapping("/deletePatient")
	public String deletePatient(@RequestParam String name) {
		return patientService.deletePatient(name);
	}
}
