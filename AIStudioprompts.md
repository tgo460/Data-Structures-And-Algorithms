Here’s a comprehensive Product Requirements Document (PRD) for CodeWhyNot 2.0, capturing all key aspects, from concept to implementation, ensuring clarity, stakeholder alignment, and readiness for development.

---

## 📄 1. Document Control

| Field        | Value                                                                    |
| ------------ | ------------------------------------------------------------------------ |
| Product Name | CodeWhyNot 2.0                                                           |
| Author       | \[Your Name]                                                             |
| Version      | 0.1 (Draft)                                                              |
| Last Updated | July 2, 2025                                                             |
| Status       | Draft                                                                    |
| Stakeholders | Product Manager, ML Engineer, Developer Evangelist, UX Designer, QA Lead |

---

## 2. Executive Summary

* Overview: An interactive tool to generate **causally-grounded counterfactuals for LLM code prompts, with AST-level semantic diffs, fidelity scores, and interactive UI.
* Launch Target: v1 prototype (MVP) in 3–4 months.
* Target Users: Developers, prompt engineers, software teams using LLMs for code.

---

## 3. Problem & Opportunity

* Current Problem:

  * LLM code tools (e.g. GitHub Copilot, Gemini) lack explanation around why small prompt changes matter.
  * Prompt tweaking is blind ad-hoc trial-and-error.
* Pain Points:

  * Unexpected code behavior due to unobserved prompt impacts.
  * Difficult to validate or trust code adaptations.
* Opportunity:

  * Offer causal interventions + AST diffing to build trust, reduce debugging cycles, and accelerate prompt engineering.

---

## 4. Product Vision & Goals

* Vision: Empower developers to explore “what if” prompt changes with transparent causal explanations and code comparisons.
* Goals:

  * Enable causal prompt interventions using SCM + Gumbel-based counterfactual sampling.
  * Provide semantic-code insights via AST diff and logic fidelity metrics.
  * Create an interactive sandbox for experimentation and learning.

---

## 5. Target Users & Use Cases

### Personas

1. Software Engineer – Seeks deterministic code modifications using LLMs.
2. Prompt Engineer – Experiments with prompt variants for reliable code outputs.

### Use Cases

* Convert a loop to recursion prompt; inspect generated code differences.
* Validate that adding an import triggers function usage.
* Explore alternative prompt structures and evaluate fidelity.

---

## 6. Features & Requirements

### 🚀 Must-Have (P0)

1. SCM Prompt Editor + Interventions

   * UI toggle or template to convert "loop" → "recursion" etc.
   * Underlying: Represent prompt nodes (NL tokens, concepts) via SCM.
2. Counterfactual Prompt Generator

   * Gumbel-node-based sampling to create semantically equivalent prompts.
3. Code Generation Integration

   * Generate code from original + counterfactual prompt via open model (Code Llama).
4. AST Diff Engine

   * Emphasize algorithmic changes (e.g., for-loop vs recursion call).
5. Fidelity Metrics

   * AST edit distance ratio, logic shift detection, syntax correctness.
6. Interactive UI Sandbox

   * Prompt input, code preview, side-by-side diff, causal tree visualization, fidelity scores.

### ↖ Should-Have (P1)

1. Multi-Agent Search

   * Genetic + gradient search for diverse prompt edits.
2. Export & Logging

   * Save code + prompt + diff + scores for reference.
3. IDE Integration

   * Starter version for VSCode.

### ✨ Nice-to-Have (P2)

1. User Feedback Survey

   * Simple thumbs-up/down and comments.
2. Multi-Language Support

   * Support Java, JavaScript, etc.

---

## 7. User Experience

### User Flow

1. Input prompt: e.g., "factorial using loop"
2. Select CF edit: e.g., "swap loop → recursion"
3. Generate code: Original + CF
4. Display diff & fidelity
5. Explore causal tree: shows prompt variants and paths
6. Iterate/edit: Try additional CFs or multi-agent suggestions

### Design Requirements

* Clean UI with prompt input, code panels, diff viewer, tree view, and scorecards.
* User-friendly interactive experience, minimal cognitive load.
* Accessible styling; responsive layout.

---

## 8. Technical Specifications

### Architecture

* Frontend: Streamlit App (Python)
* Backend:

  * SCM Module: NetworkX
  * Gumbel CF: token-level noise sampling
  * Code Generation: Transformers + Code Llama
  * AST Diff: code-diff library
  * Visualization: NetworkX for causal tree; diff\_viewer for code diff

### Performance & Scalability

* Code generation must be fast (<3s) – consider quantized model
* Diff operations are lightweight; caching optional but not necessary for initial release

### Security & Compliance

* Runs local/inference-only: no data leaves user environment
* No PII collection in MVP

---

## 9. Success Metrics & KPIs

* Feature usage: # of prompt-CF runs per user session
* Fidelity scores: average >0.8 indicating minimal semantic drift
* User satisfaction: >80% positive feedback in pilot UX surveys
* Time saved: developer test shows ≥25% reduction in prompt-edit-debug cycles vs baseline

---

## 10. Timeline & Milestones

* Month 1: SCM modeling, prompt interventions, basic code generation
* Month 2: AST diff engine, fidelity scoring, single CF UI
* Month 3: Multi-agent CF and interactive causal tree
* Month 4: User testing, refinement, and VSCode milestone

---

## 11. Constraints & Risks

* Prompt-CF semantic coverage: need to define clear templates (may limit initial diversity)
* Model fidelity: limited to open-source model's logic capabilities
* User adoption: requires developer comfort with LLM tools
* Complexity: avoid over-engineered UIs; prioritize core functionality

---

## 12. Assumptions

* Developers seek structural clarity over raw token suggestions.
* Local inference via Code Llama is performant and reliable.
* AST diffing accurately reflects semantic logic shifts.

---

## 13. Future Enhancements

* Expand to support multiple languages, cloud-hosted models
* Add advanced CF ranking via SHAP explanation scoring
* Full IDE integration for broader adoption
* Provide versioned project logs and collaborative sharing

---

## 14. Approval

| Role             | Name | Signature | Date |
| ---------------- | ---- | --------- | ---- |
| Product Manager  | \[ ] |           |      |
| Engineering Lead | \[ ] |           |      |
| UX Lead          | \[ ] |           |      |

---

That's your PRD for CodeWhyNot 2.0—a clear path from causal prompt-edit novelty to developer-ready tooling. Let me know if you'd like wireframes, acceptance test tables, or stakeholder presentation materials next!





Based on a comprehensive analysis of the three research papers and the product requirements document (PRD), the PRD for "CodeWhyNot 2.0" is most directly and heavily based on **`Methodoogy-Implementation_paper1.md` ("CodeSCM: Causal Analysis for Multi-Modal Code Generation")**.

Here is a detailed breakdown of the reasoning:

### 1. Direct Alignment of Core Problem and Domain

*   **Paper 1 (CodeSCM):** The primary objective is to use a causal framework (CodeSCM) to "systematically measure the causal effects of different prompt modalities (Natural Language, Code, I/O Examples) on the performance of Large Language Models in **code generation tasks**."
*   **PRD (CodeWhyNot 2.0):** The stated problem is that "LLM code tools...lack explanation around why small prompt changes matter," and the vision is to "empower developers to explore 'what if' prompt changes with transparent causal explanations and **code comparisons**."

This is a perfect match. Both documents are fundamentally concerned with understanding the causal relationship between a multi-part **code prompt** and the resulting **generated code**.

### 2. Shared Causal Framework (SCM for Prompts)

*   **Paper 1 (CodeSCM):** Proposes a **Structural Causal Model for Code (CodeSCM)** where the prompt is broken down into distinct modalities (nodes) like `Natural Language (NL)` and `Algorithmic Channel of Code (Code_AL)`. It performs interventions on these nodes.
*   **PRD (CodeWhyNot 2.0):** The first "Must-Have" feature is an **"SCM Prompt Editor + Interventions"** where prompt nodes (NL tokens, concepts) are represented via an SCM. The use case "convert a loop to recursion" is a direct intervention on the Natural Language (NL) node of the prompt's SCM.

This shows the PRD is building a product directly on top of the theoretical framework established in Paper 1.

### 3. Logical Extension vs. Foundational Mismatch

The PRD is not just a copy; it's an *application and extension* of Paper 1's research. It takes the analytical findings of Paper 1 and turns them into an interactive tool.

*   **From Analysis to Generation:** Paper 1 *measures* the effect of an intervention (e.g., the change in `pass@1` accuracy). The PRD takes the logical next step: it *generates and displays* the full counterfactual code resulting from the intervention, making the abstract effect visible to the user.
*   **From Text Metrics to Code Metrics:** While Papers 2 and 3 use text-based "edit distance," the PRD smartly adapts this for its specific domain by proposing an **"AST Diff Engine"** and "AST edit distance ratio." This is a crucial, domain-specific innovation for code that builds upon the general idea of comparing outputs.
*   **Borrowing the Mechanism:** The PRD specifies using "Gumbel-node-based sampling." This technical mechanism for generating the counterfactual is not in Paper 1 but is the core subject of Papers 2 and 3. The PRD cleverly pairs the **"what" and "why" from Paper 1** with the **"how" from Papers 2 and 3**.

### Why Papers 2 and 3 Are a Poorer Fit

*   **`Paper 2` ("Gumbel Counterfactual Generation"):** Is a poor fit because its interventions are on the **model itself** (e.g., knowledge editing via MEMIT, representation steering), not on the prompt. The PRD is exclusively about changing the prompt.
*   **`Paper 3` ("Counterfactual Token Generation"):** Is a slightly better fit than Paper 2 because it intervenes on the text, but it focuses on low-level, single-token interventions ("how would the story have unfolded if the model had chosen token B instead of A?"). The PRD's interventions are at a higher conceptual level ("loop" vs. "recursion") within the *input prompt*. Furthermore, both Paper 2 and 3 are for general text, not specifically code.

### Conclusion

The PRD for CodeWhyNot 2.0 uses **Paper 1 (CodeSCM) as its foundational blueprint**. It adopts its core problem statement, its specific domain (code generation), and its central concept (a Structural Causal Model for prompts). It then enhances this blueprint by incorporating a generation mechanism (Gumbel sampling, as explored in Papers 2 & 3) and adding a novel, domain-specific visualization layer (AST Diffing) to create a viable and powerful developer tool.


Based on all the findings provide a Product Requirement document to build this project to implement this as a real value project for 4 weeks internship by my college and publish the paper on this project



Of course. Here is a comprehensive Product Requirements Document (PRD) tailored for a 4-week internship project.

This PRD is aggressively scoped to ensure a demonstrable prototype (MVP) and a publishable paper are achievable within the tight timeframe. It focuses on a single, high-impact use case and prioritizes the core technical novelty.

---

## **PRD: Causal Code Counterfactuals (C3)**

| Field | Value |
| :--- | :--- |
| **Product Name** | Causal Code Counterfactuals (C3) |
| **Version** | 1.0 (Internship MVP) |
| **Status** | Approved for Kickoff |
| **Author** | [Your Name/Mentor Name] |
| **Stakeholders**| Internship Mentor, College Professor, Student Intern |
| **Last Updated** | [Date] |

### 1. Executive Summary

**C3** is a web-based tool designed to explore the causal impact of conceptual changes in code generation prompts. For a 4-week internship, the project will focus on building an MVP that allows a user to input a prompt for an iterative algorithm and, with a single click, generate a "counterfactual" recursive version. The tool will display both code versions side-by-side and provide quantitative metrics (AST Edit Distance, Functional Correctness) to analyze the differences, forming the basis for a short academic paper.

### 2. Problem & Opportunity

*   **The Problem:** When developers modify LLM prompts for code generation (e.g., changing "use a for-loop" to "use recursion"), the resulting code can change in unpredictable ways. There is no tool to isolate the *direct causal effect* of that single conceptual change, making prompt engineering feel like blind trial-and-error.
*   **The Opportunity:** By implementing a rigorous counterfactual generation mechanism (based on the Gumbel-Max trick), we can create a tool that reveals *exactly* how the model's output would have differed given a specific prompt intervention. This provides immense value for explainability, debugging, and building trust in LLM-generated code.
*   **The Academic Novelty:** The project's paper will present the implementation of a novel user-facing tool for causal code analysis and provide the first quantitative results on how specific high-level prompt interventions (iterative vs. recursive) affect code structure and correctness in a controlled, counterfactual setting.

### 3. Target Users & Use Cases (Internship Scope)

*   **Primary User:** A **Developer or ML Researcher** interested in LLM explainability for code.
*   **Core Use Case:**
    1.  A user provides a prompt for a well-known algorithm that can be solved iteratively (e.g., "Python function for factorial using a for-loop").
    2.  The tool generates the standard iterative code.
    3.  The user clicks a "Generate Recursive Counterfactual" button.
    4.  The tool generates the recursive version *using the exact same underlying sampling noise*, thus isolating the impact of the prompt change.
    5.  The user sees both code snippets and a report comparing their structural difference (AST distance) and functional correctness.

### 4. Features & Requirements (MVP for 4 Weeks)

| Priority | Feature ID | Requirement Description |
| :--- | :--- | :--- |
| **P0 (Must-Have)** | **UI-01** | **Minimalist Web Interface:** A simple web UI (using Streamlit/Gradio) with: a) a text input for the user's prompt, b) a "Generate" button, and c) a display area for outputs. |
| **P0 (Must-Have)** | **BE-01** | **Baseline Code Generation:** Integrate an open-source code LLM (e.g., CodeLlama-7B, DeepSeek-Coder-1.3B) via Hugging Face to generate code from the initial prompt. |
| **P0 (Must-Have)** | **BE-02** | **Hardcoded Counterfactual Intervention:** Implement a single, non-editable intervention: transforming the user's prompt by replacing keywords related to iteration (e.g., "loop", "iterative") with "recursion" or "recursive". This avoids complex prompt parsing. |
| **P0 (Must-Have)** | **BE-03** | **Gumbel Counterfactual Generation:** The core technical task. Implement a sampler that can: <br> 1. Generate the baseline code while *storing the random seed/state* for each token. <br> 2. Re-run generation with the modified prompt, *re-using the same random states* to generate the counterfactual code. This simulates the Gumbel-max noise replay. |
| **P0 (Must-Have)**| **MET-01** | **AST Edit Distance Metric:** After generating both code snippets, programmatically parse them into Abstract Syntax Trees (ASTs) using Python's `ast` library and compute the structural edit distance between them. Display this score. |
| **P0 (Must-Have)** | **MET-02** | **Functional Correctness (`pass@1`):** For a predefined set of test prompts (e.g., factorial, fibonacci), create a simple unit test suite. Automatically run both generated code snippets against the tests and display a Pass/Fail result. |
| **P1 (Should-Have)** | **UI-02**| **Side-by-Side Diff View:** Display the two code versions next to each other with line-by-line highlighting of differences (using a library like `diff-match-patch`). |
| **P2 (Won't Have)** | *N/A* | *User-defined interventions, multiple language support, IDE integration, complex SCM editors. These are explicitly out of scope for the 4-week MVP.* |

### 5. Technical Specifications

*   **Frontend Framework:** **Streamlit** (Recommended for its speed and simplicity in Python).
*   **Backend Language:** **Python 3.9+**
*   **Core Libraries:**
    *   `transformers` (for LLM access)
    *   `torch` (for model inference and handling random states)
    *   `ast` (built-in Python library for AST parsing)
    *   `[A simple AST diff library]` (e.g., `ast-diff` or a custom script)
*   **LLM Model:** A small, open-source code model (<7B parameters) to ensure fast execution on a single GPU (e.g., Google Colab, local machine). **DeepSeek-Coder-1.3B-Instruct** is a strong candidate.
*   **Execution Environment:** To be developed and run in a standard environment like Google Colab or a local machine with a consumer-grade GPU.

### 6. Success Metrics (For Project & Paper)

*   **Project Success (Demonstrable MVP):**
    *   A functional Streamlit app that successfully executes the core use case from start to finish.
    *   The counterfactual generation logic is implemented and produces qualitatively different (recursive) code.
*   **Paper Success (Quantitative Results):**
    *   **KPI 1: Mean AST Edit Distance:** For a set of 10-15 standard algorithmic prompts, we will report the average AST distance between the iterative and recursive versions. *Hypothesis: The distance will be significant but stable.*
    *   **KPI 2: Counterfactual Correctness Rate:** We will report the percentage of counterfactual (recursive) solutions that still pass the unit tests. *Hypothesis: Correctness will decrease, quantifying the model's difficulty with the causal intervention.*
    *   **KPI 3: Qualitative Analysis:** The paper will feature 2-3 compelling examples of the side-by-side diff, with analysis on *how* the model chose to implement the recursive logic.

### 7. 4-Week Internship Timeline & Milestones

| Week | Primary Goal | Key Tasks & Deliverables |
| :--- | :--- | :--- |
| **Week 1** | **Foundation & Baseline** | 1. Setup dev environment (Python, PyTorch, Transformers). <br> 2. Build the basic Streamlit UI (input/output boxes). <br> 3. Implement baseline code generation (BE-01). <br> **Deliverable:** A simple app that takes a prompt and generates code. |
| **Week 2**| **Core Counterfactual Logic**| 1. Implement the hardcoded prompt intervention (BE-02). <br> 2. **Implement the Gumbel noise replay mechanism (BE-03).** <br> 3. Test that the logic produces two distinct code outputs. <br> **Deliverable:** A script that can generate a factual/counterfactual pair. |
| **Week 3** | **Metrics & Integration**| 1. Implement the AST edit distance calculation (MET-01). <br> 2. Create the unit test framework for functional correctness (MET-02). <br> 3. Integrate all backend logic into the Streamlit app. <br> **Deliverable:** The complete, functional MVP. |
| **Week 4** | **Experimentation & Paper Writing**| 1. Run the experiment: process 10-15 prompts through the tool and collect all metrics. <br> 2. Analyze the data, generate plots (e.g., bar chart of AST distances). <br> 3. **Write the ~4-page research paper** (Abstract, Intro, Methodology, Results, Conclusion). <br> **Deliverable:** Final project code, a presentation, and the submitted paper draft. |

### 8. Risks & Mitigations

*   **Risk 1 (High):** Technical complexity of noise replay (BE-03) is higher than anticipated.
    *   **Mitigation:** Start with a simpler "interventional baseline" (just use a new random seed for the second prompt). This ensures a result is possible, even if it's not a "true" counterfactual. The paper can then compare the baseline to the true counterfactual approach.
*   **Risk 2 (Medium):** The chosen LLM produces very low-quality code, making analysis meaningless.
    *   **Mitigation:** Hand-pick prompts for simple, classic algorithms where models are known to perform well. Acknowledge model limitation in the paper.
*   **Risk 3 (Low):** Scope creep; temptation to add more features.
    *   **Mitigation:** Adhere strictly to this PRD. All new ideas are to be logged under "Future Work" for the paper's conclusion.




    Provide detailed project structure, requirements and implementation code and algorithms mentioned in the research paper and PRD


    Of course. This is an excellent plan for a 4-week internship. Here is a detailed breakdown of the project structure, requirements, and implementation code, designed to be achievable within the timeframe while producing novel results for a paper.

---

### 1. Project Structure

This structure separates the UI, core logic, and evaluation components for clarity and modularity.

```
C3_Project/
│
├── app.py                      # Main Streamlit application file (The UI)
│
├── c3_core/                    # Core logic for the project
│   ├── __init__.py
│   ├── generator.py            # Handles model loading and code generation (factual & counterfactual)
│   ├── evaluator.py            # Handles AST diffing and functional correctness testing
│   └── prompts.py              # Stores the predefined prompts and their unit tests
│
├── requirements.txt            # All Python package dependencies
│
└── README.md                   # Instructions for setup and running the project
```

### 2. Requirements (`requirements.txt`)

These are the necessary Python libraries. Using a small model and `accelerate` is key for performance on a consumer-grade machine.

```text
streamlit
torch
transformers
accelerate
zss # For tree edit distance on ASTs
```

### 3. Implementation Details, Code, and Algorithms

Here we break down the implementation of each file, focusing on the core algorithms from the research papers and PRD.

#### **File: `c3_core/prompts.py`**

This file centralizes the experimental data. It makes the experiment reproducible and easy to expand.

```python
# c3_core/prompts.py

PROMPT_DATA = {
    "factorial": {
        "prompt": "Write a Python function `calculate_factorial(n)` that computes the factorial of a non-negative integer n using an iterative for-loop.",
        "intervention_prompt": "Write a Python function `calculate_factorial(n)` that computes the factorial of a non-negative integer n using recursion.",
        "unit_test": """
assert calculate_factorial(0) == 1
assert calculate_factorial(1) == 1
assert calculate_factorial(5) == 120
assert calculate_factorial(7) == 5040
"""
    },
    "fibonacci": {
        "prompt": "Write a Python function `calculate_fibonacci(n)` that returns the nth Fibonacci number. Use an iterative approach with a loop, not recursion.",
        "intervention_prompt": "Write a Python function `calculate_fibonacci(n)` that returns the nth Fibonacci number. Use a recursive approach.",
        "unit_test": """
assert calculate_fibonacci(0) == 0
assert calculate_fibonacci(1) == 1
assert calculate_fibonacci(5) == 5
assert calculate_fibonacci(8) == 21
"""
    },
    # Add 1-2 more simple algorithms like power function, sum of list, etc.
}
```

---

#### **File: `c3_core/generator.py`**

This is the technical heart of the project, implementing the **Gumbel Counterfactual Generation** algorithm.

**Algorithm: Gumbel Counterfactual Generation (Simplified Implementation)**

The research papers propose reusing Gumbel noise. We can simulate this perfectly and efficiently by **reusing the random seed at each token generation step**. This forces the pseudo-random number generator into the same state for both factual and counterfactual generation, thus "replaying" the same sampling choices given the logits.

```python
# c3_core/generator.py

import torch
from transformers import AutoTokenizer, AutoModelForCausalLM

class CausalCodeGenerator:
    """
    Handles loading the LLM and generating both factual and counterfactual
    code snippets by controlling the random seed to simulate Gumbel noise replay.
    """
    def __init__(self, model_name="deepseek-ai/deepseek-coder-1.3b-instruct"):
        print("Loading model... This may take a moment.")
        self.tokenizer = AutoTokenizer.from_pretrained(model_name, trust_remote_code=True)
        self.model = AutoModelForCausalLM.from_pretrained(model_name, trust_remote_code=True, torch_dtype=torch.bfloat16).cuda()
        self.model.eval()
        print("Model loaded successfully.")

    def _generate_single_version(self, prompt, master_seed, max_new_tokens=150):
        """
        Generates a single piece of code, carefully controlling the seed at each step.
        """
        # Format the prompt in the way the model expects (e.g., DeepSeek-Coder Instruct format)
        messages = [
            {'role': 'user', 'content': prompt}
        ]
        inputs = self.tokenizer.apply_chat_template(messages, add_generation_prompt=True, return_tensors="pt").to(self.model.device)
        
        # Store generated token IDs
        generated_ids = inputs
        
        with torch.no_grad():
            for step in range(max_new_tokens):
                # THE CORE ALGORITHM: Set the seed for this specific step
                # This ensures the sampling for this step is identical in both factual and counterfactual runs
                torch.manual_seed(master_seed + step)

                # Get model outputs (logits)
                outputs = self.model(generated_ids)
                logits = outputs.logits[:, -1, :]

                # Sample the next token
                # Using multinomial sampling is equivalent to the Gumbel-Max trick
                probs = torch.nn.functional.softmax(logits, dim=-1)
                next_token_ids = torch.multinomial(probs, num_samples=1)

                # Append the new token
                generated_ids = torch.cat([generated_ids, next_token_ids], dim=1)

                # Stop if EOS token is generated
                if next_token_ids[0, -1] == self.tokenizer.eos_token_id:
                    break
        
        # Decode the full output and clean up the prompt
        full_output = self.tokenizer.decode(generated_ids[0], skip_special_tokens=True)
        # This part might need adjustment based on the model's output format
        code_part = full_output.split("```python")[-1].split("```")[0].strip()
        return code_part

    def generate_causal_pair(self, factual_prompt, counterfactual_prompt, master_seed=42):
        """
        Generates a factual and a counterfactual code pair using the same master seed.
        """
        print("Generating factual (original) code...")
        factual_code = self._generate_single_version(factual_prompt, master_seed)

        print("Generating counterfactual code...")
        counterfactual_code = self._generate_single_version(counterfactual_prompt, master_seed)

        return factual_code, counterfactual_code
```

---

#### **File: `c3_core/evaluator.py`**

This file handles the two key metrics required by the PRD.

**Algorithm: AST Edit Distance**

We use the `ast` library to parse code into a tree and `zss` to compute the tree-to-tree distance. This quantifies the structural difference, ignoring superficial changes like comments or variable names.

```python
# c3_core/evaluator.py
import ast
from zss import simple_distance, Node

# Helper class to adapt Python's AST nodes for the zss library
class ASTNode(Node):
    def __init__(self, ast_node):
        self.ast_node = ast_node
        super().__init__(ast_node.__class__.__name__) # The label is the node type (e.g., 'For', 'FunctionDef')

    def get_children(self):
        return [ASTNode(child) for child in ast.iter_child_nodes(self.ast_node)]

def calculate_ast_distance(code1, code2):
    """
    Parses two Python code strings into ASTs and computes the edit distance.
    Returns the distance and the parsed trees for inspection.
    """
    try:
        tree1 = ast.parse(code1)
        tree2 = ast.parse(code2)
        
        adapted_tree1 = ASTNode(tree1)
        adapted_tree2 = ASTNode(tree2)
        
        # zss.simple_distance calculates the Zhang-Shasha tree edit distance
        distance = simple_distance(adapted_tree1, adapted_tree2)
        return distance
    except SyntaxError as e:
        print(f"Syntax error during AST parsing: {e}")
        return -1 # Return an error code

def run_functional_test(generated_code, unit_test_code):
    """
    Executes generated code against a unit test.
    Returns "Pass" or "Fail" with the error message.
    """
    # Create a combined script to execute
    full_script = f"{generated_code}\n\n{unit_test_code}"
    
    try:
        # Using a dedicated locals dictionary to execute the code in
        exec_locals = {}
        exec(full_script, globals(), exec_locals)
        return "✅ Pass", None
    except AssertionError as e:
        return "❌ Fail (Assertion)", str(e)
    except Exception as e:
        return f"❌ Fail (Runtime Error)", str(e)
```

---

#### **File: `app.py`**

This is the user-facing part, tying everything together with a simple UI.

```python
# app.py
import streamlit as st
from c3_core.generator import CausalCodeGenerator
from c3_core.evaluator import calculate_ast_distance, run_functional_test
from c3_core.prompts import PROMPT_DATA

# --- Page Configuration ---
st.set_page_config(
    page_title="Causal Code Counterfactuals (C3)",
    layout="wide"
)

st.title("🔬 Causal Code Counterfactuals (C3)")
st.markdown("An MVP for exploring causal interventions in LLM code generation. Based on research in counterfactual generation.")

# --- Load Model (Cached to prevent reloading on every interaction) ---
@st.cache_resource
def load_generator():
    return CausalCodeGenerator()

generator = load_generator()

# --- UI Components ---
st.sidebar.header("Controls")
selected_problem = st.sidebar.selectbox("1. Choose a Problem", list(PROMPT_DATA.keys()))
master_seed = st.sidebar.slider("2. Master Random Seed", 1, 100, 42, help="Change this to see how randomness affects both versions.")

if st.sidebar.button("Generate Causal Pair", type="primary"):
    # Get prompts and test for the selected problem
    problem_data = PROMPT_DATA[selected_problem]
    factual_prompt = problem_data["prompt"]
    counterfactual_prompt = problem_data["intervention_prompt"]
    unit_test = problem_data["unit_test"]

    # --- Generation ---
    with st.spinner("Generating causal pair... This might take up to a minute."):
        factual_code, counterfactual_code = generator.generate_causal_pair(
            factual_prompt, counterfactual_prompt, master_seed
        )

    # --- Evaluation ---
    with st.spinner("Evaluating outputs..."):
        ast_dist = calculate_ast_distance(factual_code, counterfactual_code)
        factual_status, factual_error = run_functional_test(factual_code, unit_test)
        counterfactual_status, counterfactual_error = run_functional_test(counterfactual_code, unit_test)
    
    # --- Display Results ---
    st.header("Results")
    st.subheader("High-Level Metrics")
    
    metric1, metric2, metric3 = st.columns(3)
    metric1.metric("AST Edit Distance", f"{ast_dist if ast_dist != -1 else 'Syntax Error'}", help="Measures the structural difference between the code. Higher means more different.")
    metric2.metric("Factual Code Correctness", factual_status)
    metric3.metric("Counterfactual Code Correctness", counterfactual_status)

    if factual_error:
        st.error(f"Factual Code Error: {factual_error}")
    if counterfactual_error:
        st.warning(f"Counterfactual Code Error: {counterfactual_error}")

    st.subheader("Code Comparison")
    col1, col2 = st.columns(2)

    with col1:
        st.markdown("#### Factual (Original) Code")
        st.code(factual_code, language="python")

    with col2:
        st.markdown("#### Counterfactual Code")
        st.code(counterfactual_code, language="python")

else:
    st.info("Select a problem from the sidebar and click 'Generate Causal Pair' to begin.")
```



convert this project structure into run in the colabs Jupiter notebook







Of course. Converting the multi-file project into a single Google Colab notebook is an excellent way to make it easily shareable, reproducible, and ready for an internship presentation.

This notebook is structured with clear cells that mirror the original project's files, and it replaces the Streamlit UI with Colab's native `ipywidgets` for interactivity.

---

### **Google Colab Notebook: Causal Code Counterfactuals (C3)**

You can create a new notebook in Google Colab ([colab.research.google.com](https://colab.research.google.com)) and paste the contents of each numbered section into its own cell.

**Important:** Before running, make sure to set the runtime to use a GPU. Go to `Runtime` -> `Change runtime type` and select `T4 GPU` or another available GPU.

---

#### **Cell 1: Setup and Installations**

This cell installs all necessary libraries and imports the required modules for the entire project.

```python
# Cell 1: Setup and Installations

# Install required packages
!pip install -q transformers accelerate zss torch

# Import all necessary libraries
import torch
import ast
from transformers import AutoTokenizer, AutoModelForCausalLM
from zss import simple_distance, Node
import ipywidgets as widgets
from IPython.display import display, Markdown, clear_output

print("✅ All libraries installed and imported successfully.")
```

---

#### **Cell 2: Configuration - Prompts and Unit Tests**

This cell contains the data for our experiments, mirroring the `prompts.py` file.

```python
# Cell 2: Configuration - Prompts and Unit Tests

PROMPT_DATA = {
    "factorial": {
        "prompt": "Write a Python function `calculate_factorial(n)` that computes the factorial of a non-negative integer n using an iterative for-loop.",
        "intervention_prompt": "Write a Python function `calculate_factorial(n)` that computes the factorial of a non-negative integer n using recursion.",
        "unit_test": """
assert calculate_factorial(0) == 1
assert calculate_factorial(1) == 1
assert calculate_factorial(5) == 120
assert calculate_factorial(7) == 5040
"""
    },
    "fibonacci": {
        "prompt": "Write a Python function `calculate_fibonacci(n)` that returns the nth Fibonacci number. Use an iterative approach with a loop, not recursion.",
        "intervention_prompt": "Write a Python function `calculate_fibonacci(n)` that returns the nth Fibonacci number. Use a recursive approach.",
        "unit_test": """
assert calculate_fibonacci(0) == 0
assert calculate_fibonacci(1) == 1
assert calculate_fibonacci(5) == 5
assert calculate_fibonacci(8) == 21
"""
    },
    "sum_of_list": {
        "prompt": "Write a Python function `sum_list(items)` that calculates the sum of a list of numbers using a for-loop.",
        "intervention_prompt": "Write a Python function `sum_list(items)` that calculates the sum of a list of numbers using recursion.",
        "unit_test": """
assert sum_list([1, 2, 3]) == 6
assert sum_list([]) == 0
assert sum_list([-1, 0, 1]) == 0
assert sum_list([10]) == 10
"""
    }
}

print("✅ Prompt and test data loaded.")
```

---

#### **Cell 3: Core Logic - The Evaluator**

This cell contains the functions for calculating AST distance and running functional tests, mirroring `evaluator.py`.

```python
# Cell 3: Core Logic - The Evaluator

# Helper class to adapt Python's AST nodes for the zss library
class ASTNode(Node):
    def __init__(self, ast_node):
        self.ast_node = ast_node
        super().__init__(ast_node.__class__.__name__)

    def get_children(self):
        return [ASTNode(child) for child in ast.iter_child_nodes(self.ast_node)]

def calculate_ast_distance(code1, code2):
    """Parses two Python code strings into ASTs and computes the edit distance."""
    try:
        tree1 = ast.parse(code1)
        tree2 = ast.parse(code2)
        adapted_tree1 = ASTNode(tree1)
        adapted_tree2 = ASTNode(tree2)
        distance = simple_distance(adapted_tree1, adapted_tree2)
        return distance
    except SyntaxError:
        return -1

def run_functional_test(generated_code, unit_test_code):
    """Executes generated code against a unit test."""
    full_script = f"{generated_code}\n\n{unit_test_code}"
    try:
        exec_locals = {}
        exec(full_script, globals(), exec_locals)
        return "✅ Pass", None
    except AssertionError as e:
        return "❌ Fail (Assertion)", str(e)
    except Exception as e:
        return f"❌ Fail (Runtime Error)", str(e)

print("✅ Evaluator functions defined.")
```

---

#### **Cell 4: Core Logic - The Causal Generator**

This is the technical heart of the project, mirroring `generator.py`.

```python
# Cell 4: Core Logic - The Causal Generator

class CausalCodeGenerator:
    """
    Handles loading the LLM and generating both factual and counterfactual
    code snippets by controlling the random seed to simulate Gumbel noise replay.
    """
    def __init__(self, model_name="deepseek-ai/deepseek-coder-1.3b-instruct"):
        self.device = "cuda" if torch.cuda.is_available() else "cpu"
        self.tokenizer = AutoTokenizer.from_pretrained(model_name, trust_remote_code=True)
        self.model = AutoModelForCausalLM.from_pretrained(model_name, trust_remote_code=True, torch_dtype=torch.bfloat16).to(self.device)
        self.model.eval()

    def _generate_single_version(self, prompt, master_seed, max_new_tokens=150):
        messages = [{'role': 'user', 'content': prompt}]
        inputs = self.tokenizer.apply_chat_template(messages, add_generation_prompt=True, return_tensors="pt").to(self.device)
        generated_ids = inputs
        with torch.no_grad():
            for step in range(max_new_tokens):
                torch.manual_seed(master_seed + step)
                outputs = self.model(generated_ids)
                logits = outputs.logits[:, -1, :]
                probs = torch.nn.functional.softmax(logits, dim=-1)
                next_token_ids = torch.multinomial(probs, num_samples=1)
                generated_ids = torch.cat([generated_ids, next_token_ids], dim=1)
                if next_token_ids[0, -1] == self.tokenizer.eos_token_id:
                    break
        full_output = self.tokenizer.decode(generated_ids[0], skip_special_tokens=True)
        try:
            code_part = full_output.split("```python")[1].split("```")[0].strip()
        except IndexError:
            code_part = full_output.split("### Response:")[1].strip() # Fallback for different formatting
        return code_part

    def generate_causal_pair(self, factual_prompt, counterfactual_prompt, master_seed=42):
        factual_code = self._generate_single_version(factual_prompt, master_seed)
        counterfactual_code = self._generate_single_version(counterfactual_prompt, master_seed)
        return factual_code, counterfactual_code

# --- Instantiate the model once to avoid reloading ---
# This replaces the need for Streamlit's @st.cache_resource
print("Loading model... This may take a few minutes the first time.")
generator = CausalCodeGenerator()
clear_output() # Clean up the loading messages
print("✅ Causal Generator is ready.")
```

---

#### **Cell 5: Interactive UI and Main Application Logic**

This final cell creates the interactive widget-based UI and ties all the logic together. It replaces `app.py`.

```python
# Cell 5: Interactive UI and Main Application Logic

# --- Create UI Widgets ---
problem_dropdown = widgets.Dropdown(
    options=list(PROMPT_DATA.keys()),
    description='Problem:',
    value='factorial'
)

seed_slider = widgets.IntSlider(
    value=42,
    min=1,
    max=100,
    step=1,
    description='Master Seed:',
    continuous_update=False
)

generate_button = widgets.Button(
    description='Generate Causal Pair',
    button_style='success',
    icon='cogs'
)

# Output area to display all results
output_area = widgets.Output()

# --- Define the function that runs on button click ---
def on_generate_button_clicked(b):
    with output_area:
        clear_output(wait=True) # Clear previous results
        print("🚀 Starting generation and evaluation...")

        # Get selected values from UI
        problem_key = problem_dropdown.value
        master_seed = seed_slider.value
        problem_data = PROMPT_DATA[problem_key]

        # Generate the code
        print("🧠 Generating causal pair...")
        factual_code, counterfactual_code = generator.generate_causal_pair(
            problem_data["prompt"], problem_data["intervention_prompt"], master_seed
        )
        print("✅ Generation complete.")

        # Evaluate the outputs
        print("📊 Evaluating outputs...")
        ast_dist = calculate_ast_distance(factual_code, counterfactual_code)
        factual_status, factual_error = run_functional_test(factual_code, problem_data["unit_test"])
        counterfactual_status, counterfactual_error = run_functional_test(counterfactual_code, problem_data["unit_test"])
        print("✅ Evaluation complete.")
        
        clear_output(wait=True) # Clear status messages for a clean final output

        # --- Display Results ---
        display(Markdown("---"))
        display(Markdown("### 📊 High-Level Metrics"))
        
        # Create a horizontal box for metrics
        metrics_html = f"""
        <div style="display: flex; justify-content: space-around; text-align: center;">
            <div>
                <p style="font-size: 1.2em; margin-bottom: 0;">AST Edit Distance</p>
                <p style="font-size: 1.5em; font-weight: bold;">{ast_dist if ast_dist != -1 else 'Syntax Error'}</p>
            </div>
            <div>
                <p style="font-size: 1.2em; margin-bottom: 0;">Factual Correctness</p>
                <p style="font-size: 1.5em; font-weight: bold;">{factual_status}</p>
            </div>
            <div>
                <p style="font-size: 1.2em; margin-bottom: 0;">Counterfactual Correctness</p>
                <p style="font-size: 1.5em; font-weight: bold;">{counterfactual_status}</p>
            </div>
        </div>
        """
        display(widgets.HTML(value=metrics_html))
        
        if factual_error:
            display(Markdown(f"<p style='color:red;'><b>Factual Code Error:</b> {factual_error}</p>"))
        if counterfactual_error:
            display(Markdown(f"<p style='color:orange;'><b>Counterfactual Code Error:</b> {counterfactual_error}</p>"))

        display(Markdown("### ↔️ Code Comparison"))
        
        # Display code side-by-side
        factual_output = widgets.Output()
        with factual_output:
            display(Markdown(f"#### Factual (Original) Code"))
            display(Markdown(f"```python\n{factual_code}\n```"))

        counterfactual_output = widgets.Output()
        with counterfactual_output:
            display(Markdown(f"#### Counterfactual Code"))
            display(Markdown(f"```python\n{counterfactual_code}\n```"))
            
        side_by_side = widgets.HBox([factual_output, counterfactual_output])
        display(side_by_side)


# --- Link the button to the function ---
generate_button.on_click(on_generate_button_clicked)

# --- Display the UI ---
# Arrange controls in a horizontal box
controls = widgets.HBox([problem_dropdown, seed_slider, generate_button])
# Display the final application layout
display(widgets.VBox([controls, output_area]))
```