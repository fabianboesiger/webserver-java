package server.renderer.commands;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

import server.renderer.InterpreterException;
import server.renderer.Renderer;

public class NotCommand extends Command {
		
	@Override
	public Object run(StringBuilder code, LinkedList <String> languages, Map <String, Object> variables, StringBuilder printer) throws IOException, InterpreterException {
		return !((boolean) Renderer.runNext(code, languages, variables, printer));
		
	}
	
}
