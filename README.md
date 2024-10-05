# ATUDGUP
Here is the relevant code and data for our proposed approach ATUDGUP. Data in main branch.

## StaticAnalysisTool
This folder is used to extract the types of production code changes that make test code obsolete and to construct prompts.

This is a Java project, and all the JAR files in the jars folder need to be imported in order to run it.

The file StaticAnalysisTool/src/use/usage.java provides a detailed demonstration of how to use this tool to extract code change types and construct prompts. To construct prompts, a sample set is required, and the sample set used in our experiments is located in the main branch.

## eval
This folder is used to evaluate the experimental results, calculate each evaluation metrics. Our experimental results and prompts are stored in the result.zip file in the main branch.
