package jenkins.python.expoint;


import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jenkins.model.Jenkins;
import hudson.Extension;
import hudson.ExtensionList;
import hudson.ExtensionPoint;
import hudson.Functions;
import hudson.model.User;
import hudson.tasks.*;
import hudson.tasks.UserAvatarResolver.*;
import jenkins.python.DataConvertor;
import jenkins.python.PythonExecutor;

/**
 * This class was automatically generated by the PWM tool on 2014/03/21.
 * @see hudson.tasks.UserAvatarResolver
 */
public abstract class UserAvatarResolverPW extends UserAvatarResolver {
	private transient PythonExecutor pexec;

	private void initPython() {
		if (pexec == null) {
			pexec = new PythonExecutor(this);
			String[] jMethods = new String[1];
			jMethods[0] = "findAvatarFor";
			String[] pFuncs = new String[1];
			pFuncs[0] = "find_avatar_for";
			Class[][] argTypes = new Class[1][];
			argTypes[0] = new Class[3];
			argTypes[0][0] = User.class;
			argTypes[0][1] = int.class;
			argTypes[0][2] = int.class;
			pexec.checkAbstrMethods(jMethods, pFuncs, argTypes);
			String[] functions = new String[0];
			int[] argsCount = new int[0];
			pexec.registerFunctions(functions, argsCount);
		}
	}

	@Override
	public String findAvatarFor(User u, int width, int height) {
		initPython();
		return (String) pexec.execPython("find_avatar_for", u, DataConvertor.fromInt(width), DataConvertor.fromInt(height));
	}

	public Object execPython(String function, Object... params) {
		initPython();
		return pexec.execPython(function, params);
	}

	public byte execPythonByte(String function, Object... params) {
		initPython();
		return pexec.execPythonByte(function, params);
	}

	public short execPythonShort(String function, Object... params) {
		initPython();
		return pexec.execPythonShort(function, params);
	}

	public char execPythonChar(String function, Object... params) {
		initPython();
		return pexec.execPythonChar(function, params);
	}

	public int execPythonInt(String function, Object... params) {
		initPython();
		return pexec.execPythonInt(function, params);
	}

	public long execPythonLong(String function, Object... params) {
		initPython();
		return pexec.execPythonLong(function, params);
	}

	public float execPythonFloat(String function, Object... params) {
		initPython();
		return pexec.execPythonFloat(function, params);
	}

	public double execPythonDouble(String function, Object... params) {
		initPython();
		return pexec.execPythonDouble(function, params);
	}

	public boolean execPythonBool(String function, Object... params) {
		initPython();
		return pexec.execPythonBool(function, params);
	}

	public void execPythonVoid(String function, Object... params) {
		initPython();
		pexec.execPythonVoid(function, params);
	}
}