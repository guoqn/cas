package generate;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import org.exolab.castor.builder.SourceGenerator;
import org.exolab.castor.builder.binding.BindingException;
import org.exolab.castor.builder.binding.BindingLoader;
import org.exolab.castor.builder.binding.ExtendedBinding;
import org.exolab.castor.builder.binding.xml.Binding;
import org.exolab.castor.builder.binding.xml.PackageType;
import org.exolab.castor.builder.factory.FieldInfoFactory;
import org.exolab.castor.util.CommandLineOptions;

/**
 * .
 *
 * @author Luxb
 * @version Revision 1.0.0
 * @版权：福富软件 版权所有 (c) 2011
 * @see: @创建日期：2016/1/16 @功能说明：
 */
public class AutoGenerate {

	private final static String CAS_SRC = "\\src\\main\\resources\\xsd\\cas";
	private final static String CRM_SRC = "\\src\\main\\resources\\xsd\\crm";
	private final static String SMS_SRC = "\\src\\main\\resources\\xsd\\sms";
	private final static String PAD_SRC = "\\src\\main\\resources\\xsd\\pad";
	private final static String HB_SRC = "\\src\\main\\resources\\xsd\\hb";

	/**
	 * xsd文件存放位置.
	 */
	public String src = "\\src\\main\\resources\\xsd\\crm";
	/**
	 * java代码输出位置.
	 */
	public String dest = "\\src\\main\\java";
	/**
	 * 名称.
	 */
	public String name = "crm";
	/**
	 * 如果生成单个xsd的java文件，需要指定xsd文件名.
	 */
	public String srcXsd = "";

	private generate.xsd.File[] files;

	private String user_dir = "";

	private void generate() {
		try {
			// 从crm.xml中读取配置信息
			unmarshallerFile(src + "\\crm.xml");
			// 生成bind.xml文件
			generateBindFile(src + "\\bind.xml");

			for (int i = 0; i < files.length; i++) {
				System.out.println("-----: " + files[i].getName());

				/*
				 * if (!srcXsd.equals("")) { if (files[i].getPackage() != null
				 * && files[i].getName().equals(srcXsd))// one { } }
				 */

				if (files[i].getPackage() != null && files[i].getName() != null
						&& (srcXsd.equals("") || srcXsd.equals(files[i].getName())))// all
				{
					System.out.print("Createing: " + files[i].getName());
					String[] args = new String[10];
					args[0] = "-f";
					args[1] = "-nomarshall";
					args[2] = "-binding-file";
					args[3] = src + "/bind.xml";
					args[4] = "-package";
					args[5] = files[i].getPackage();
					args[6] = "-dest";
					args[7] = dest;
					args[8] = "-i";
					args[9] = src + "/" + files[i].getName();
					System.out.println(" --- Package:" + args[5]);
					generateSource(args);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		AutoGenerate gen = new AutoGenerate();

		gen.user_dir = System.getProperty("user.dir");

		gen.src = gen.user_dir + gen.src;
		gen.dest = gen.user_dir + gen.dest;

		System.out.println("src  dir :" + gen.src);
		System.out.println("dest dir :" + gen.dest);

		/**
		 * 集团GROUP
		 */
		gen.src = gen.user_dir + CRM_SRC;
		// 配置这句则只编译该schema, srcXsd应对crm.xml中file标签的name属性
		// gen.srcXsd="PROD_INST_BO.xsd";
		// gen.srcXsd="custManager/CUST_POINT.xsd";
		// gen.srcXsd="prodOfferInst/PROD_OFFER_INST.xsd";
		// gen.srcXsd="custManager/CUST.xsd";
		// gen.srcXsd="orderManager/CUST_ORDER.xsd";
		// gen.srcXsd="prodInst/PROD_INST.xsd";
		// TODO;注意更改gen.src地址
		gen.srcXsd = "checkcancel/checkCancel.xsd";
		// gen.srcXsd="CUST_ORDER_BO.xsd";
		// gen.srcXsd="CUST_BO.xsd";
		// gen.srcXsd="orderManager/CHECK_RULE.xsd";

		/**
		 * 服开PF
		 */
		// gen.src=PF_SRC;
		// gen.srcXsd="crm_wait_req.xsd";
		// gen.srcXsd="Tcp.xsd";
		// System.out.println(gen.src);
		// gen.generate();

		/**
		 * 计费
		 */
		// gen.src=BILL_SRC;
		// gen.srcXsd="MERGE_CUST.xsd";
		// gen.srcXsd="ORDER_DEAL.xsd";

		/**
		 * NP
		 */
		// gen.src=NP_SRC;
		// gen.srcXsd="NP_INTER_MESSAGE.xsd";
		System.out.println(gen.src);
		gen.generate();
	}

	// TODO
	private void unmarshallerFile(String fileName) {
		try {
			java.io.FileInputStream fis = new java.io.FileInputStream(fileName);
			InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
			generate.xsd.Design design = (generate.xsd.Design) org.exolab.castor.xml.Unmarshaller
					.unmarshal(generate.xsd.Design.class, reader);
			files = design.getFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TODO
	private void generateBindFile(String fileName) {
		try {
			Binding binding = new Binding();
			ArrayList packageTypeArray = new ArrayList();

			for (int i = 0; i < files.length; i++) {
				if (files[i].getPackage() != null && files[i].getName() != null) {
					PackageType packageType = new PackageType();
					packageType.setName(files[i].getPackage());
					org.exolab.castor.builder.binding.xml.PackageTypeChoice choice = new org.exolab.castor.builder.binding.xml.PackageTypeChoice();
					choice.setSchemaLocation(files[i].getName());
					packageType.setPackageTypeChoice(choice);
					packageTypeArray.add(packageType);
				}
			}

			binding.setPackage((PackageType[]) (packageTypeArray.toArray(new PackageType[packageTypeArray.size()])));
			binding.setDefaultBindingType(org.exolab.castor.builder.binding.xml.types.BindingType.TYPE);

			java.io.FileOutputStream fos = new java.io.FileOutputStream(fileName);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			org.exolab.castor.xml.Marshaller.marshal(binding, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// TODO
	private void generateSource(String[] args) throws Exception {

		CommandLineOptions allOptions = new CommandLineOptions();

		// -- filename flag
		allOptions.addFlag("i", "filename", "Sets the input filename");

		// -- package name flag
		allOptions.addFlag("package", "package-name", "Sets the package name", true);

		// -- destination directory
		String desc = "Sets the destination output directory";
		allOptions.addFlag("dest", "dest-dir", desc, true);

		// -- line break flag
		desc = "Sets the line separator style for the desired platform";
		allOptions.addFlag("line-separator", "( unix | mac | win)", desc, true);

		// -- Force flag
		desc = "Suppresses non fatal warnings, such as overwriting files.";
		allOptions.addFlag("f", "", desc, true);

		// -- Help flag
		desc = "Displays this help screen.";
		allOptions.addFlag("h", "", desc, true);

		// -- verbose flag
		desc = "Prints out additional messages when creaing source";
		allOptions.addFlag("verbose", "", desc, true);

		// -- no descriptors flag
		desc = "Disables the generation of the Class descriptors";
		allOptions.addFlag("nodesc", "", desc, true);

		// -- no descriptors flag
		desc = "Indicates that a mapping file should be generated";
		allOptions.addFlag("gen-mapping", "filename", desc, true);

		// -- source generator types name flag
		desc = "Sets the source generator types name (SGTypeFactory)";
		allOptions.addFlag("types", "types", desc, true);

		// -- XXX maintained temporarily
		allOptions.addFlag("type-factory", "classname", "", true);

		// -- no marshalling framework methods
		desc = "Disables the generation of the methods specific to the XML marshalling framework";
		allOptions.addFlag("nomarshall", "", desc, true);

		// -- implements org.exolab.castor.tests.CastorTestable?
		desc = "Implements some specific methods to allow the generated classes to be used with Castor Testing Framework";
		allOptions.addFlag("testable", "", desc, true);

		// -- use SAX1?
		desc = "Uses SAX 1 in the generated code.";
		allOptions.addFlag("sax1", "", desc, true);

		// -- Source Generator Binding
		desc = "Sets the Source Generator Binding File name";
		allOptions.addFlag("binding-file", "filename", desc, true);

		// -- Generates sources for imported XML Schemas
		desc = "Generates sources for imported XML schemas";
		allOptions.addFlag("generateImportedSchemas", "", desc, true);

		// -- Process the specified command line options
		Properties options = allOptions.getOptions(args);

		// -- check for help option
		if (options.getProperty("h") != null) {
			PrintWriter pw = new PrintWriter(System.out, true);
			allOptions.printHelp(pw);
			pw.flush();
			return;
		}

		String schemaFilename = options.getProperty("i");
		String packageName = options.getProperty("package");
		String lineSepStyle = options.getProperty("line-separator");
		boolean force = (options.getProperty("f") != null);
		String typeFactory = options.getProperty("types");
		boolean verbose = (options.getProperty("verbose") != null);

		if (schemaFilename == null) {
			System.out.println("Castor");
			allOptions.printUsage(new PrintWriter(System.out));
			return;
		}

		// -- XXX maintained temporarily
		if (typeFactory == null)
			typeFactory = options.getProperty("type-factory");

		String lineSep = System.getProperty("line.separator");
		if (lineSepStyle != null) {
			if ("win".equals(lineSepStyle)) {
				System.out.println(" - using Windows style line separation.");
				lineSep = "\r\n";
			} else if ("unix".equals(lineSepStyle)) {
				System.out.println(" - using UNIX style line separation.");
				lineSep = "\n";
			} else if ("mac".equals(lineSepStyle)) {
				System.out.println(" - using Macintosh style line separation.");
				lineSep = "\r";
			} else {
				System.out.print("- invalid option for line-separator: ");
				System.out.println(lineSepStyle);
				System.out.println("-- using default line separator for this platform");
			}
		}

		SourceGenerator sgen = null;
		if (typeFactory != null) {
			// --Backward compatibility
			if (typeFactory.equals("j2"))
				typeFactory = "arraylist";

			try {

				FieldInfoFactory factory = new FieldInfoFactory(typeFactory);
				sgen = new SourceGenerator(factory);
			} catch (Exception x) {
				// --one might want to use its own FieldInfoFactory
				try {
					sgen = new SourceGenerator((FieldInfoFactory) Thread.currentThread().getContextClassLoader()
							.loadClass(typeFactory).newInstance());
				} catch (Exception e) {

					System.out.print("- invalid option for types: ");
					System.out.println(typeFactory);
					System.out.println(x);
					System.out.println("-- using default source generator types");
					sgen = new SourceGenerator(); // default
				}
			}
		} else {
			sgen = new SourceGenerator(); // default
		}

		sgen.setDestDir(options.getProperty("dest"));
		sgen.setLineSeparator(lineSep);
		sgen.setSuppressNonFatalWarnings(force);
		sgen.setVerbose(verbose);

		if (force)
			// System.out.println("-- Suppressing non fatal warnings.");

			if (options.getProperty("nodesc") != null) {
				sgen.setDescriptorCreation(false);
				System.out.print("-- ");
				System.out.println("Disabling generation of Class descriptors");
			}

		if (options.getProperty("gen-mapping") != null) {
			sgen.setGenerateMappingFile(true);
			String filename = options.getProperty("gen-mapping");
			if (filename.length() > 0) {
				// sgen._mappingFilename = filename;
			}
			System.out.print("-- generating mapping file: " + filename);
		}

		if (options.getProperty("nomarshall") != null) {
			sgen.setCreateMarshalMethods(false);
			// System.out.print("-- ");
			// System.out
			// .println("Disabling generation of Marshalling framework methods
			// (marshall, unmarshall, validate).");
		}

		if (options.getProperty("testable") != null) {
			sgen.setTestable(true);
			System.out.print("-- ");
			System.out.println("The generated classes will implement org.exolab.castor.tests.CastorTestable");
		}

		if (options.getProperty("sax1") != null) {
			sgen.setSAX1(true);
			System.out.print("-- ");
			System.out.println("The generated classes will use SAX 1");
		}

		if (options.getProperty("binding-file") != null) {
			ExtendedBinding binding = null;
			try {
				binding = BindingLoader.createBinding(options.getProperty("binding-file"));
			} catch (BindingException e) {
				System.out.print("--");
				System.out.println("Unable to load a binding file due to the following Exception:");
				e.printStackTrace();
				System.out.println("-- No binding file will be used");
			}
			sgen.setBinding(binding);
		}

		if (options.getProperty("generateImportedSchemas") != null) {
			sgen.setGenerateImportedSchemas(true);
			System.out.print("-- ");
			System.out.println("Imported XML Schemas will be processed automatically.");
		}

		try {
			sgen.generateSource(schemaFilename, packageName);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
